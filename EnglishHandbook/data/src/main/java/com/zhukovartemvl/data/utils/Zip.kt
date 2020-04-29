package com.zhukovartemvl.data.utils

import net.lingala.zip4j.ZipFile
import java.io.File


fun unpackZip(file: File, dbName: String, path: String, password: String): Boolean {
    try {
        val zipFile = ZipFile(file)
        if (!zipFile.isValidZipFile) {
            return false
        }

        if (zipFile.isEncrypted) {
            zipFile.setPassword(password.toCharArray())
        }

        zipFile.extractFile(dbName, path)
        file.delete()
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }
    return true
}
