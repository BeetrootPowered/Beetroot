package com.beetroot.server.network

import br.com.devsrsouza.ktmcpacket.MinecraftProtocol
import br.com.devsrsouza.ktmcpacket.PacketState
import br.com.devsrsouza.ktmcpacket.packets.ServerPacket
import kotlinx.serialization.KSerializer

class NetConnection(val connection: dynamic) : NetworkConnection {

    override var state: PacketState = PacketState.HANDSHAKE
    private var buffer: Buffer = Buffer.alloc(0)

    init {
        connection.on("data", this::onData)
    }

    override fun sendPacket(packet: ServerPacket) {
        val packetType = state.byKClass[packet::class]
            ?: throw Error("Packet " + packet::class.simpleName + " is not registered for this state")

        val bytes = MinecraftProtocol.dump(packetType.serializer as KSerializer<ServerPacket>, packet)
        val data = Buffer.from(bytes.toTypedArray())

        val idSize = getVarIntSize(packetType.id)
        val length = bytes.size + idSize
        val lengthSize = getVarIntSize(length)

        val header = Buffer.alloc(idSize + lengthSize)
        header.writeVarInt(length, 0)
        header.writeVarInt(packetType.id, lengthSize)

        connection.write(Buffer.concat(arrayOf(header, data)))
    }

    override fun close() {
        connection.end()
    }

    private fun onData(buf: Buffer) {
        buffer = Buffer.concat(arrayOf(buffer, buf))

        while(buffer.length > 0) {
            var offset = 0

            val packetSize = buffer.readVarInt(offset)

            if (packetSize.value + packetSize.size > buffer.length) {
                return
            }

            offset += packetSize.size

            val packetId = buffer.readVarInt(offset)
            offset += packetId.size

            val packetType = state.clientById[packetId.value]

            if (packetType != null && PacketBus.hasHandlers(packetType.kclass)) {

                val bytes = buffer.toArray(offset, packetSize.value - packetId.size)
                val packet = MinecraftProtocol.load(packetType.serializer, bytes)

                PacketBus.trigger(this, packet)
                buffer = buffer.slice(offset + bytes.size)

            } else {

                // Skips this packet
                buffer = buffer.slice(offset + packetSize.size - packetId.size)

            }
        }
    }

}