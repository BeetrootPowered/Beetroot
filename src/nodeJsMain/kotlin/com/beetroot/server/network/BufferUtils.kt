package com.beetroot.server.network

import org.khronos.webgl.*
import kotlin.experimental.and

external open class Buffer(size: Number) : Uint8Array {
    constructor(array: Uint8Array)
    constructor(array: Array<Any>)
    constructor(buffer: Buffer)
    constructor(str: String, encoding: String)
    constructor(arrayBuffer: ArrayBuffer)
    open fun write(string: String, encoding: String = definedExternally): Number
    open fun write(string: String, offset: Number, encoding: String = definedExternally): Number
    open fun write(string: String, offset: Number, length: Number, encoding: String = definedExternally): Number
    open fun toString(encoding: String = definedExternally, start: Number = definedExternally, end: Number = definedExternally): String
    open fun equals(otherBuffer: Uint8Array): Boolean
    open fun compare(otherBuffer: Uint8Array, targetStart: Number = definedExternally, targetEnd: Number = definedExternally, sourceStart: Number = definedExternally, sourceEnd: Number = definedExternally): Number
    open fun copy(targetBuffer: Uint8Array, targetStart: Number = definedExternally, sourceStart: Number = definedExternally, sourceEnd: Number = definedExternally): Number
    open fun slice(begin: Number = definedExternally, end: Number = definedExternally): Buffer
    open fun subarray(begin: Number = definedExternally, end: Number = definedExternally): Buffer
    open fun writeUIntLE(value: Number, offset: Number, byteLength: Number): Number
    open fun writeUIntBE(value: Number, offset: Number, byteLength: Number): Number
    open fun writeIntLE(value: Number, offset: Number, byteLength: Number): Number
    open fun writeIntBE(value: Number, offset: Number, byteLength: Number): Number
    open fun readUIntLE(offset: Number, byteLength: Number): Number
    open fun readUIntBE(offset: Number, byteLength: Number): Number
    open fun readIntLE(offset: Number, byteLength: Number): Number
    open fun readIntBE(offset: Number, byteLength: Number): Number
    open fun readUInt8(offset: Number = definedExternally): Number
    open fun readUInt16LE(offset: Number = definedExternally): Number
    open fun readUInt16BE(offset: Number = definedExternally): Number
    open fun readUInt32LE(offset: Number = definedExternally): Number
    open fun readUInt32BE(offset: Number = definedExternally): Number
    open fun readInt8(offset: Number = definedExternally): Number
    open fun readInt16LE(offset: Number = definedExternally): Number
    open fun readInt16BE(offset: Number = definedExternally): Number
    open fun readInt32LE(offset: Number = definedExternally): Number
    open fun readInt32BE(offset: Number = definedExternally): Number
    open fun readFloatLE(offset: Number = definedExternally): Number
    open fun readFloatBE(offset: Number = definedExternally): Number
    open fun readDoubleLE(offset: Number = definedExternally): Number
    open fun readDoubleBE(offset: Number = definedExternally): Number
    open fun reverse(): Buffer /* this */
    open fun swap16(): Buffer
    open fun swap32(): Buffer
    open fun swap64(): Buffer
    open fun writeUInt8(value: Number, offset: Number = definedExternally): Number
    open fun writeUInt16LE(value: Number, offset: Number = definedExternally): Number
    open fun writeUInt16BE(value: Number, offset: Number = definedExternally): Number
    open fun writeUInt32LE(value: Number, offset: Number = definedExternally): Number
    open fun writeUInt32BE(value: Number, offset: Number = definedExternally): Number
    open fun writeInt8(value: Number, offset: Number = definedExternally): Number
    open fun writeInt16LE(value: Number, offset: Number = definedExternally): Number
    open fun writeInt16BE(value: Number, offset: Number = definedExternally): Number
    open fun writeInt32LE(value: Number, offset: Number = definedExternally): Number
    open fun writeInt32BE(value: Number, offset: Number = definedExternally): Number
    open fun writeFloatLE(value: Number, offset: Number = definedExternally): Number
    open fun writeFloatBE(value: Number, offset: Number = definedExternally): Number
    open fun writeDoubleLE(value: Number, offset: Number = definedExternally): Number
    open fun writeDoubleBE(value: Number, offset: Number = definedExternally): Number
    open fun fill(value: String, offset: Number = definedExternally, end: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer /* this */
    open fun fill(value: Uint8Array, offset: Number = definedExternally, end: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer /* this */
    open fun fill(value: Number, offset: Number = definedExternally, end: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer /* this */
    open fun indexOf(value: String, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    open fun indexOf(value: Number, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    open fun indexOf(value: Uint8Array, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    open fun lastIndexOf(value: String, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    open fun lastIndexOf(value: Number, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    open fun lastIndexOf(value: Uint8Array, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
    open fun includes(value: String, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
    open fun includes(value: Number, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
    open fun includes(value: Buffer, byteOffset: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Boolean
    open fun write(string: String): Number
    open fun write(string: String, offset: Number): Number
    open fun write(string: String, offset: Number, length: Number): Number

    companion object {
        fun from(arrayBuffer: ArrayBuffer, byteOffset: Number = definedExternally, length: Number = definedExternally): Buffer
        fun from(data: Array<Number>): Buffer
        fun from(data: Uint8Array): Buffer
        fun from(obj: Any, byteOffset: Number = definedExternally, length: Number = definedExternally): Buffer
        fun from(str: String, encoding: String = definedExternally): Buffer
        fun of(vararg items: Number): Buffer
        fun isBuffer(obj: Any): Boolean
        fun isEncoding(encoding: String): Boolean
        fun byteLength(string: String, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: Uint8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: Uint8ClampedArray, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: Uint16Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: Uint32Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: Int8Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: Int16Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: Int32Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: Float32Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: Float64Array, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: DataView, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun byteLength(string: ArrayBuffer, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Number
        fun concat(list: Array<Uint8Array>, totalLength: Number = definedExternally): Buffer
        fun compare(buf1: Uint8Array, buf2: Uint8Array): Number
        fun alloc(size: Number, fill: String = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer
        fun alloc(size: Number, fill: Buffer = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer
        fun alloc(size: Number, fill: Number = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "latin1" | "binary" | "hex" */ = definedExternally): Buffer
        fun allocUnsafe(size: Number): Buffer
        fun allocUnsafeSlow(size: Number): Buffer
        var poolSize: Number
        fun from(str: String): Buffer
        fun alloc(size: Number): Buffer
    }
}

class VarIntValue(val value: Int, val size: Int)

fun Buffer.readVarInt(offset: Int): VarIntValue {
    var numRead = 0
    var result = 0
    var read: Byte
    do {
        read = this[offset + numRead]
        val value = (read and 127).toInt()
        result = result or (value shl 7 * numRead)
        numRead++
        if (numRead > 5) {
            throw RuntimeException("VarInt is too big")
        }
    } while (read and 128.toByte() != 0.toByte())

    return VarIntValue(result, numRead)
}

fun Buffer.writeVarInt(value: Int, offset: Int) : Int {
    var write: Int = value
    var bytesWritten = 0

    while (write and -128 != 0) {
        writeUInt8(write and 127 or 128, offset + bytesWritten)
        bytesWritten++
        write = write ushr 7
    }

    writeUInt8(write, offset + bytesWritten)
    return bytesWritten + 1
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

fun Buffer.toArray(offset: Int, length: Int) : ByteArray {
    val bytes = ByteArray(length)
    for (i in 0..length) {
        bytes[i] = this[offset + i]
    }
    return bytes
}
