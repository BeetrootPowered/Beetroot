package com.beetroot.server.network

import br.com.devsrsouza.ktmcpacket.MinecraftProtocol
import br.com.devsrsouza.ktmcpacket.PacketState
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder

class PacketDecoder : ByteToMessageDecoder() {

    override fun decode(ctx: ChannelHandlerContext, buffer: ByteBuf, out: MutableList<Any>) {
        buffer.markReaderIndex()

        // TODO check whether the bytes from the packet size are readable
        val packetSize = buffer.readVarInt()

        // Checks and awaits whether the whole packet is not readable
        if (buffer.readableBytes() < packetSize) {
            buffer.resetReaderIndex()
            return
        }

        val readerIndex = buffer.readerIndex()
        val packetId = buffer.readVarInt()

        val state = ctx.channel().attr(Network.STATE_ATTRIBUTE_KEY).get() ?: PacketState.HANDSHAKE
        val packetType = state.clientById[packetId]

        if (packetType != null && PacketBus.hasHandlers(packetType.kclass)) {

            // Calculates the amount of data to read (packetSize - packetIdSize)
            val dataSize = packetSize - (buffer.readerIndex() - readerIndex)

            try {
                // Reads into an byte array
                val bytes = ByteArray(dataSize)
                buffer.readBytes(bytes)

                // Deserializes the packet
                out.add(MinecraftProtocol.load(packetType.serializer, bytes))

            } catch (ex: Exception) {
                // If something goes wrong, we'll skip to the next packet
                ex.printStackTrace() // TODO proper logging
                buffer.readerIndex(readerIndex + packetSize)
            }

        } else {

            // Skips to the next packet
            buffer.readerIndex(readerIndex + packetSize)
            return

        }

    }

}