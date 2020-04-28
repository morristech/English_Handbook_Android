package com.zhukovartemvl.data.utils

import net.lingala.zip4j.exception.ZipException
import net.lingala.zip4j.io.inputstream.ZipInputStream
import net.lingala.zip4j.model.LocalFileHeader
import java.io.*


//fun inputStream: InputStream, path: String, password: String): Boolean {
//    try {
//        if (destDir.isDirectory && !destDir.exists()) {
//            destDir.mkdir()
//        }
//
//        //2.初始化zip工具
//        val zFile = ZipFile(zipFile)
//        zFile.setFileNameCharset("UTF-8")
//        if (!zFile.isValidZipFile) {
//            throw ZipException("压缩文件不合法,可能被损坏.")
//        }
//        //3.判断是否已加密
//        if (zFile.isEncrypted) {
//            zFile.setPassword(passwd!!.toCharArray())
//        }
//        //4.解压所有文件
//        zFile.extractAll(destDir.absolutePath)
//        val headerList: MutableList<FileHeader?> = zFile.fileHeaders as MutableList<FileHeader?>
//        val extractedFileList: MutableList<File> = ArrayList()
//        for (fileHeader in headerList) {
//            if (!fileHeader!!.isDirectory) {
//                extractedFileList.add(File(destDir, fileHeader.fileName))
//            }
//        }
//    } catch (e: ZipException) {
//        e.printStackTrace()
//        return false
//    }
//    return true
//}

fun unpackZip(inputStream: InputStream, path: String, password: String): Boolean {
    try {
        var localFileHeader: LocalFileHeader
        var readLen: Int
        val readBuffer = ByteArray(4096)

        ZipInputStream(BufferedInputStream(inputStream) as InputStream, password.toCharArray()).use { zipInputStream ->
            val file = File(path)
            if (!file.exists()) {
                file.mkdirs()
            }

            while (zipInputStream.nextEntry.also { localFileHeader = it } != null) {

                val outputFile = File(file, localFileHeader.fileName)
//                if (!outputFile.canonicalPath.startsWith(path)) {
//                    return false
//                }

//                val extractedFile = File(localFileHeader.fileName)
                FileOutputStream(outputFile).use { outputStream ->

                    while (zipInputStream.read(readBuffer).also { readLen = it } != -1) {
                        outputStream.write(readBuffer, 0, readLen)
                    }

                }
            }
        }
    } catch (e: ZipException) {
        return false
    }
    return true
}

//fun unpackZip(inputStream: InputStream, path: String, password: String): Boolean {
//    try {
//        ZipFile("filename.zip", "password".toCharArray()).extractAll("/destination_directory")
//
////        ZipFile("englishDB.zip").
//
//
////        val decryptInputStream = ZipDecryptInputStream(inputStream, password)
////        ZipInputStream(decryptInputStream).use { zipInputStream ->
////
////            val file = File(path)
////            if (!file.exists())
////                file.mkdirs()
////
////            var zipEntry: ZipEntry
////            while (zipInputStream.nextEntry.also { zipEntry = it } != null) {
////
////                val outputFile = File(file, zipEntry.name)
////                if (!outputFile.canonicalPath.startsWith(path))
////                    return false
////
////                FileOutputStream(outputFile).use { fileOutputStream ->
////                    var b: Int
////                    while (zipInputStream.read().also { b = it } != -1) {
////                        fileOutputStream.write(b)
////                    }
////                }
////                zipInputStream.closeEntry()
////            }
////
////        }
//    } catch (e: Exception) {
//        return false
//    }
//    return true
//}
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
