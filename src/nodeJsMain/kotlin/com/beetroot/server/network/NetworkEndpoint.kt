package com.beetroot.server.network

external var require: (module: String) -> dynamic

val net = require("net")

actual class NetworkEndpoint internal actual constructor(actual val options: NetworkOptions) {

    val server: dynamic

    init {
        server = net.createServer(this::onConnect)

        server.on("error") { err: Error -> throw err }
        server.listen(options.port, options.ip)
    }

    private fun onConnect(con: dynamic) {
        val connection = NetConnection(con)

        con.setTimeout(1000 * options.timeoutSeconds)
        //con.setNoDelay(true)
        // TODO
    }

    fun close() {
        server.close()
    }

}