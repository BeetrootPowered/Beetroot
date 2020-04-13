package com.beetroot.server.network

expect object Network {

    val endpoints: List<NetworkEndpoint>

    fun listen(options: NetworkOptions) : NetworkEndpoint

    fun close(endpoint: NetworkEndpoint)

    fun closeAll()

}