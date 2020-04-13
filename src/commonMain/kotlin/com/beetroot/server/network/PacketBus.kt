package com.beetroot.server.network

import br.com.devsrsouza.ktmcpacket.packets.Packet
import kotlin.reflect.KClass

typealias PacketHandler<T> = (NetworkConnection, T) -> Unit

object PacketBus {

    private val handlers : HashMap<KClass<out Packet>, ArrayList<PacketHandler<Packet>>> = HashMap()

    fun <T : Packet> subscribe(packetType: KClass<T>, handler: PacketHandler<T>) {
        (handlers.getOrPut(packetType) { ArrayList() } as ArrayList<PacketHandler<T>>).add(handler)
    }

    fun <T : Packet> unsubscribe(packetType: KClass<T>, handler: PacketHandler<T>) {
        handlers[packetType]?.remove(handler)
    }

    internal fun hasHandlers(packetType: KClass<out Packet>) : Boolean {
        val registeredHandlers = handlers[packetType]
        return registeredHandlers != null && registeredHandlers.any()
    }

    internal fun <T : Packet> trigger(connection: NetworkConnection, packet: T) {
        handlers[packet::class]?.forEach { it.invoke(connection, packet) }
    }


}