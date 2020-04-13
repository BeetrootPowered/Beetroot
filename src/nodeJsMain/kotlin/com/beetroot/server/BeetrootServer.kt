package com.beetroot.server

import br.com.devsrsouza.ktmcpacket.PacketState
import br.com.devsrsouza.ktmcpacket.packets.client.Handshake
import br.com.devsrsouza.ktmcpacket.packets.client.HandshakeNextState
import br.com.devsrsouza.ktmcpacket.packets.client.status.Ping
import br.com.devsrsouza.ktmcpacket.packets.client.status.Request
import br.com.devsrsouza.ktmcpacket.packets.server.status.Pong
import br.com.devsrsouza.ktmcpacket.packets.server.status.ServerListPing
import com.beetroot.server.network.Network
import com.beetroot.server.network.NetworkOptions
import com.beetroot.server.network.PacketBus

fun main() {
    Network.listen(NetworkOptions("localhost"))
    Network.listen(NetworkOptions("localhost", 25566))

    PacketBus.subscribe(Handshake::class) { connection, packet ->
        if (packet.nextState == HandshakeNextState.LOGIN)
            connection.state = PacketState.LOGIN
        else
            connection.state = PacketState.STATUS
    }

    PacketBus.subscribe(Ping::class) { connection, packet ->
        connection.sendPacket(Pong(packet.payload))
        connection.close()
    }

    PacketBus.subscribe(Request::class) { connection, packet ->
        connection.sendPacket(ServerListPing("{\"version\":{\"name\":\"1.15.2\",\"protocol\":578},\"players\":{\"max\":1000,\"online\":500,\"sample\":[]},\"description\":{\"text\":\"kt-mc-packet test\"}}"))
    }
}