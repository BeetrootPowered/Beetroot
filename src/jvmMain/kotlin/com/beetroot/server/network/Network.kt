package com.beetroot.server.network

import br.com.devsrsouza.ktmcpacket.PacketState
import io.netty.util.AttributeKey

actual object Network {

    val STATE_ATTRIBUTE_KEY: AttributeKey<PacketState> = AttributeKey.valueOf("packet_state")
    private val registeredEndpoints: ArrayList<NetworkEndpoint> = ArrayList()

    actual val endpoints: List<NetworkEndpoint>
        get() = registeredEndpoints

    actual fun listen(options: NetworkOptions): NetworkEndpoint {
        val endpoint = NetworkEndpoint(options)
        registeredEndpoints.add(endpoint)
        return endpoint
    }

    actual fun close(endpoint: NetworkEndpoint) {
        registeredEndpoints.remove(endpoint)
        endpoint.channel.channel().close()
    }

    actual fun closeAll() {
        for (endpoint in registeredEndpoints) {
            try {
                endpoint.channel.channel().close()
            } catch(err: Exception) {
                // NOOP
            }
        }

        registeredEndpoints.clear()
    }

}