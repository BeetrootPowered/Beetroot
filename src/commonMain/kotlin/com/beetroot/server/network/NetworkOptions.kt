package com.beetroot.server.network

data class NetworkOptions(
    val ip: String,
    val port: Int = 25565,
    val nativeTransport: Boolean = true,
    val timeoutSeconds: Int = 30
)