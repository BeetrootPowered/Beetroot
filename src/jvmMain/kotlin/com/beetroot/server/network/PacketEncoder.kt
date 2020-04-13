package com.beetroot.server.network

import br.com.devsrsouza.ktmcpacket.MinecraftProtocol
import br.com.devsrsouza.ktmcpacket.PacketState
import br.com.devsrsouza.ktmcpacket.packets.ServerPacket
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder
import kotlinx.serialization.KSerializer

class PacketEncoder : MessageToByteEncoder<ServerPacket>() {

    override fun encode(ctx: ChannelHandlerContext, packet: ServerPacket, buffer: ByteBuf) {
        val state = ctx.channel().attr(Network.STATE_ATTRIBUTE_KEY).get() ?: PacketState.HANDSHAKE

        val packetType = state.byKClass[packet::class]
            ?: throw RuntimeException("Packet " + packet::class.simpleName + " is not registered")

        val data = MinecraftProtocol.dump(packetType.serializer as KSerializer<ServerPacket>, packet)
        val packetSize = data.size + getVarIntSize(packetType.id)

        buffer.writeVarInt(packetSize)
        buffer.ensureWritable(packetSize)
        buffer.writeVarInt(packetType.id)
        buffer.writeBytes(data)
    }

}
