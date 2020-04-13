package com.beetroot.server.network

import io.netty.buffer.ByteBuf
import kotlin.experimental.and

fun ByteBuf.readVarInt(): Int {
    var numRead = 0
    var result = 0
    var read: Byte
    do {
        read = this.readByte()
        val value = (read and 127).toInt()
        result = result or (value shl 7 * numRead)
        numRead++
        if (numRead > 5) {
            throw RuntimeException("VarInt is too big")
        }
    } while (read and 128.toByte() != 0.toByte())
    return result
}

fun ByteBuf.writeVarInt(value: Int) {
    var write: Int = value

    while (write and -128 != 0) {
        writeByte(write and 127 or 128)
        write = write ushr 7
    }

    writeByte(write)
}

fun getVarIntSize(value: Int) : Int {
    var write: Int = value
    var bytesWritten = 1

    while (write and -128 != 0) {
        bytesWritten++
        write = write ushr 7
    }

    return bytesWritten
}
