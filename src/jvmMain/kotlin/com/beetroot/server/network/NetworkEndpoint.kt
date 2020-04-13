package com.beetroot.server.network

import br.com.devsrsouza.ktmcpacket.PacketState
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.*
import io.netty.channel.epoll.Epoll
import io.netty.channel.epoll.EpollEventLoopGroup
import io.netty.channel.epoll.EpollServerSocketChannel
import io.netty.channel.kqueue.KQueue
import io.netty.channel.kqueue.KQueueEventLoopGroup
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.util.concurrent.DefaultThreadFactory

actual class NetworkEndpoint internal actual constructor(actual val options: NetworkOptions) : ChannelInitializer<Channel>() {

    val channel: ChannelFuture

    init {
        val bootstrap = ServerBootstrap()

        if (options.nativeTransport && Epoll.isAvailable()) {
            setupEpoll(bootstrap)
        } else if(options.nativeTransport && KQueue.isAvailable()) {
            setupKqueue(bootstrap)
        } else {
            setupNio(bootstrap)
        }

        bootstrap.localAddress(options.ip, options.port)
        bootstrap.childHandler(this)

        channel = bootstrap.bind()
    }

    private fun setupEpoll(bootstrap: ServerBootstrap) {
        bootstrap.channel(EpollServerSocketChannel::class.java)
        bootstrap.group(EpollEventLoopGroup(0, DefaultThreadFactory("beetroot_epoll")))
        // TODO custom ThreadFactory
    }

    private fun setupKqueue(bootstrap: ServerBootstrap) {
        bootstrap.channel(KQueueServerSocketChannel::class.java)
        bootstrap.group(KQueueEventLoopGroup(0, DefaultThreadFactory("beetroot_kqueue")))
        // TODO custom ThreadFactory
    }

    private fun setupNio(bootstrap: ServerBootstrap) {
        bootstrap.channel(NioServerSocketChannel::class.java)
        bootstrap.group(NioEventLoopGroup(0, DefaultThreadFactory("beetroot_nio")))
        // TODO custom ThreadFactory
    }

    override fun initChannel(channel: Channel) {
        try {
            channel.config().setOption(ChannelOption.TCP_NODELAY, true)
        } catch (ex: ChannelException) {
        }

        val connection = NettyConnection(channel)
        connection.state = PacketState.HANDSHAKE

        channel.pipeline()
            .addLast("timeout", ReadTimeoutHandler(options.timeoutSeconds))
            .addLast("decoder", PacketDecoder())
            .addLast("encoder", PacketEncoder())
            .addLast("handler", connection)

        // TODO add connection to a list
    }

}