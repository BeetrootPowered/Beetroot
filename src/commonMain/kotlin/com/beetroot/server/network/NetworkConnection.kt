package com.beetroot.server.network

import br.com.devsrsouza.ktmcpacket.PacketState
import br.com.devsrsouza.ktmcpacket.packets.ServerPacket

interface NetworkConnection {

    var state: PacketState

    fun sendPacket(packet: ServerPacket)

    fun close()

}