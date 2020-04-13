package com.beetroot.server.network

import br.com.devsrsouza.ktmcpacket.PacketState
import br.com.devsrsouza.ktmcpacket.packets.ClientPacket
import br.com.devsrsouza.ktmcpacket.packets.ServerPacket
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler

class NettyConnection(val channel: Channel) : SimpleChannelInboundHandler<ClientPacket>(), NetworkConnection {

    override var state: PacketState
        get() = channel.attr(Network.STATE_ATTRIBUTE_KEY).get() ?: PacketState.HANDSHAKE
        set(value) = channel.attr(Network.STATE_ATTRIBUTE_KEY).set(value)

    override fun sendPacket(packet: ServerPacket) {
        channel.writeAndFlush(packet)
    }

    override fun close() {
        channel.close()
    }

    override fun channelRead0(ctx: ChannelHandlerContext, msg: ClientPacket) {
        PacketBus.trigger(this, msg)
    }

}