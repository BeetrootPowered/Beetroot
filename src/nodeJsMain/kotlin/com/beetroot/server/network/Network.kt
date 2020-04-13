package com.beetroot.server.network

actual object Network {

    val registeredEndpoints: ArrayList<NetworkEndpoint> = ArrayList()

    actual val endpoints: List<NetworkEndpoint>
        get() = registeredEndpoints

    actual fun listen(options: NetworkOptions): NetworkEndpoint {
        val endpoint = NetworkEndpoint(options)
        registeredEndpoints.add(endpoint)
        return endpoint
    }

    actual fun close(endpoint: NetworkEndpoint) {
        registeredEndpoints.remove(endpoint)
        endpoint.close()
    }

    actual fun closeAll() {
        registeredEndpoints.forEach { it.close() }
        registeredEndpoints.clear()
    }


}