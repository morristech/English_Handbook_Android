package com.zhukovartemvl.data.db

import android.content.Context
import androidx.room.Room
import com.zhukovartemvl.data.utils.unpackZip
import com.zhukovartemvl.shared.model.DatabaseInfo
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.net.URL


class DatabaseLoaderImpl(private val dbInfo: DatabaseInfo) {

    lateinit var instance: AppDatabase
        private set

    fun init(context: Context): Boolean {
        val isExists = databaseExists()

        if (!isExists) {
            val isDatabaseDownloaded = downloadDatabase()
            if (!isDatabaseDownloaded)
                return false
        }

        initDatabase(context)
        return true
    }

    fun updateDatabase(context: Context): Boolean {
        if (downloadDatabase()) {
            initDatabase(context)
            return true
        }
        return false
    }

    fun updateAvailable(): Boolean {
        val version = instance.parameterDao().getParameters.version
        val updateVersion = getUpdateVersion()
        return version < updateVersion
    }

    private fun databaseExists() = File(dbInfo.path + dbInfo.dbName).exists()

    private fun initDatabase(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, dbInfo.dbName)
            .build()
            .also { instance = it }

    private fun downloadDatabase(): Boolean {
        try {
            URL(dbInfo.link).openStream().use { input ->
                val file = File(dbInfo.path, dbInfo.zipName)

                FileOutputStream(file).use { output ->
                    input.copyTo(output)
                    return unpackZip(file, dbInfo.dbName, dbInfo.path, dbInfo.password)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    private fun getUpdateVersion(): Double {
        return try {
            URL(dbInfo.versionLink).openStream().use { input ->
                val version = input.bufferedReader().use { it.readText() }
                version.toDouble()
            }
        } catch (e: Exception) {
            0.0
        }
    }

}
