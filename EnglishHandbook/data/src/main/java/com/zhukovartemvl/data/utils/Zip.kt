package com.zhukovartemvl.data.utils

import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

//New

//ДОБАВИТЬ ПУТЬ, КУДА БУДЕТ РАСПАКОВЫВАТЬСЯ АРХИВ
//http://blog.alutam.com/2009/10/31/reading-password-protected-zip-files-in-java/


fun unpackZip(inputStream: InputStream, path: String, password: String): Boolean {
    try {
        val decryptInputStream = ZipDecryptInputStream(inputStream, password)
        ZipInputStream(decryptInputStream).use { zipInputStream ->

            val file = File(path)
            if (!file.exists())
                file.mkdirs()

            var zipEntry: ZipEntry
            while (zipInputStream.nextEntry.also { zipEntry = it } != null) {

                val outputFile = File(file, zipEntry.name)
                if (!outputFile.canonicalPath.startsWith(path))
                    return false

                FileOutputStream(outputFile).use { fileOutputStream ->
                    var b: Int
                    while (zipInputStream.read().also { b = it } != -1) {
                        fileOutputStream.write(b)
                    }
                }
                zipInputStream.closeEntry()
            }

        }
    } catch (e: Exception) {
        return false
    }
    return true
}
//
//fun main(filename: String, password: String) {
//    val fis = FileInputStream(filename)
//    val zdis = ZipDecryptInputStream(fis, password)
//    val zis = ZipInputStream(zdis)
//
//    var ze: ZipEntry
//    while (zis.nextEntry.also { ze = it } != null) {
//        val fos = FileOutputStream(ze.name)
//        var b: Int
//        while (zis.read().also { b = it } != -1) {
//            fos.write(b)
//        }
//        fos.close()
//        zis.closeEntry()
//    }
//    zis.close()
//}
//
//
//fun unpackZip2(inputStream: InputStream, password: String) {
//    val zipDecryptInputStream = ZipDecryptInputStream(inputStream, password)
//
//    ZipInputStream(zipDecryptInputStream).use { zipInputStream ->
//        var ze: ZipEntry
//        while (zipInputStream.nextEntry.also { ze = it } != null) {
//
//
//            FileOutputStream(ze.name).use { fileOutputStream ->
//                var b: Int
//                while (zipInputStream.read().also { b = it } != -1) {
//                    fileOutputStream.write(b)
//                }
//            }
//            zipInputStream.closeEntry()
//        }
//    }
//}
//
//
////--------------------------------------
//
////val zipFile = File("path_to_your_zip_file")
////file.unzip()
//
//data class ZipIO(val entry: ZipEntry, val output: File)
//
//fun File.unzip(unzipLocationRoot: File? = null) {
//
//    val rootFolder =
//        unzipLocationRoot ?: File(parentFile.absolutePath + File.separator + nameWithoutExtension)
//    if (!rootFolder.exists()) {
//        rootFolder.mkdirs()
//    }
//
//    ZipFile(this).use { zip ->
//        zip
//            .entries()
//            .asSequence()
//            .map {
//                val outputFile = File(rootFolder.absolutePath + File.separator + it.name)
//                ZipIO(it, outputFile)
//            }
//            .map {
//                it.output.parentFile?.run {
//                    if (!exists()) mkdirs()
//                }
//                it
//            }
//            .filter { !it.entry.isDirectory }
//            .forEach { (entry, output) ->
//                zip.getInputStream(entry).use { input ->
//                    output.outputStream().use { output ->
//                        input.copyTo(output)
//                    }
//                }
//            }
//    }
//
//}
//
//
////Old
////fun unpackZip(path: String, inputStream: InputStream): Boolean {
////    try {
////        ZipInputStream(BufferedInputStream(inputStream) as InputStream).use { zipInputStream ->
////            val file = File(path)
////            if (!file.exists()) {
////                file.mkdirs()
////            }
////
////            while (true) {
////                val zipEntry: ZipEntry = zipInputStream.nextEntry
////                    ?: break
////
////                val outputFile = File(file, zipEntry.name)
////                if (!outputFile.canonicalPath.startsWith(path)) {
////                    return false
////                }
////                FileOutputStream(outputFile).use { fileOutputStream ->
////                    var len: Int
////                    val byteArray = ByteArray(1024)
////                    while (zipInputStream.read(byteArray).also { len = it } != -1) {
////                        fileOutputStream.write(byteArray, 0, len)
////                    }
////                }
////                zipInputStream.closeEntry()
////            }
////        }
////        return true
////    } catch (iOException: IOException) {
////        iOException.printStackTrace()
////        return false
////    }
////}
