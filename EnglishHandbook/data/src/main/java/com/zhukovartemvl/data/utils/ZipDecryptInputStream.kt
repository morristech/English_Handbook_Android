package com.zhukovartemvl.data.utils

import java.io.IOException
import java.io.InputStream


class ZipDecryptInputStream(private val delegate: InputStream, private val password: String) :
    InputStream() {
    companion object {
        private val CRC_TABLE = IntArray(256)
        private const val DECRYPT_HEADER_SIZE = 12
        private val LFH_SIGNATURE = intArrayOf(0x50, 0x4b, 0x03, 0x04)

        init {
            for (i in 0..255) {
                var r = i
                for (j in 0..7) {
                    r = if (r and 1 == 1) {
                        r ushr 1 xor -0x12477ce0
                    } else {
                        r ushr 1
                    }
                }
                CRC_TABLE[i] = r
            }
        }
    }

    private val keys = IntArray(3)
    private var state = State.SIGNATURE
    private var skipBytes = 0
    private var compressedSize = 0
    private var value = 0
    private var valuePos = 0
    private var valueInc = 0

    @Throws(IOException::class)
    override fun read(): Int {
        var result = delegate.read()
        if (skipBytes == 0) {
            when (state) {
                State.SIGNATURE -> if (result != LFH_SIGNATURE[valuePos]
                ) {
                    state = State.TAIL
                } else {
                    valuePos++
                    if (valuePos >= LFH_SIGNATURE.size) {
                        skipBytes = 2
                        state = State.FLAGS
                    }
                }
                State.FLAGS -> {
                    check(result and 1 != 0) { "ZIP not password protected." }
                    check(result and 64 != 64) { "Strong encryption used." }
                    check(result and 8 != 8) { "Unsupported ZIP format." }
                    result -= 1
                    compressedSize = 0
                    valuePos = 0
                    valueInc = DECRYPT_HEADER_SIZE
                    state = State.COMPRESSED_SIZE
                    skipBytes = 11
                }
                State.COMPRESSED_SIZE -> {
                    compressedSize += result shl 8 * valuePos
                    result -= valueInc
                    if (result < 0) {
                        valueInc = 1
                        result += 256
                    } else {
                        valueInc = 0
                    }
                    valuePos++
                    if (valuePos > 3) {
                        valuePos = 0
                        value = 0
                        state = State.FN_LENGTH
                        skipBytes = 4
                    }
                }
                State.FN_LENGTH, State.EF_LENGTH -> {
                    value += result shl 8 * valuePos
                    if (valuePos == 1) {
                        valuePos = 0
                        if (state == State.FN_LENGTH) {
                            state = State.EF_LENGTH
                        } else {
                            state = State.HEADER
                            skipBytes = value
                        }
                    } else {
                        valuePos = 1
                    }
                }
                State.HEADER -> {
                    initKeys(password)
                    var i = 0
                    while (i < DECRYPT_HEADER_SIZE) {
                        updateKeys((result xor decryptByte().toInt()).toByte())
                        result = delegate.read()
                        i++
                    }
                    compressedSize -= DECRYPT_HEADER_SIZE
                    state = State.DATA
                    result = result xor decryptByte().toInt() and 0xff
                    updateKeys(result.toByte())
                    compressedSize--
                    if (compressedSize == 0) {
                        valuePos = 0
                        state = State.SIGNATURE
                    }
                }
                State.DATA -> {
                    result = result xor decryptByte().toInt() and 0xff
                    updateKeys(result.toByte())
                    compressedSize--
                    if (compressedSize == 0) {
                        valuePos = 0
                        state = State.SIGNATURE
                    }
                }
                State.TAIL -> {
                }
            }
        } else {
            skipBytes--
        }
        return result
    }

    @Throws(IOException::class)
    override fun close() {
        delegate.close()
        super.close()
    }

    private fun initKeys(password: String) {
        keys[0] = 305419896
        keys[1] = 591751049
        keys[2] = 878082192
        for (element in password) {
            updateKeys((element.toInt() and 0xff).toByte())
        }
    }

    private fun updateKeys(charAt: Byte) {
        keys[0] = crc32(keys[0], charAt)
        keys[1] += keys[0] and 0xff
        keys[1] = keys[1] * 134775813 + 1
        keys[2] = crc32(keys[2], (keys[1] shr 24).toByte())
    }

    private fun decryptByte(): Byte {
        val temp = keys[2] or 2
        return (temp * (temp xor 1) ushr 8).toByte()
    }

    private fun crc32(oldCrc: Int, charAt: Byte): Int {
        return oldCrc ushr 8 xor CRC_TABLE[oldCrc xor charAt.toInt() and 0xff]
    }

    private enum class State {
        SIGNATURE, FLAGS, COMPRESSED_SIZE, FN_LENGTH, EF_LENGTH, HEADER, DATA, TAIL
    }
}
