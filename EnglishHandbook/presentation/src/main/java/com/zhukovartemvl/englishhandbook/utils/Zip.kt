package com.zhukovartemvl.englishhandbook.utils

import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


fun unpackZip(path: String, inputStream: InputStream): Boolean {
    try {
        ZipInputStream(BufferedInputStream(inputStream) as InputStream).use { zipInputStream ->
            val file = File(path)
            if (!file.exists()) {
                file.mkdirs()
            }

            while (true) {
                val zipEntry: ZipEntry = zipInputStream.nextEntry
                    ?: break

                val outputFile = File(file, zipEntry.name)
                if (!outputFile.canonicalPath.startsWith(path)) {
                    return false
                }
                FileOutputStream(outputFile).use { fileOutputStream ->
                    var len: Int
                    val byteArray = ByteArray(1024)
                    while (zipInputStream.read(byteArray).also { len = it } != -1) {
                        fileOutputStream.write(byteArray, 0, len)
                    }
                }
                zipInputStream.closeEntry()
            }
        }
        return true
    } catch (iOException: IOException) {
        iOException.printStackTrace()
        return false
    }
}
