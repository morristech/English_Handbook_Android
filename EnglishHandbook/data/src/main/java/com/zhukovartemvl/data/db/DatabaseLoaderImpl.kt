package com.zhukovartemvl.data.db

import android.content.Context
import androidx.room.Room
import com.zhukovartemvl.data.utils.unpackZip
import com.zhukovartemvl.shared.model.DatabaseInfo
import com.zhukovartemvl.shared.repository.DatabaseLoader
import java.io.File
import java.lang.Exception
import java.net.URL


class DatabaseLoaderImpl(private val databaseInfo: DatabaseInfo) : DatabaseLoader {

    lateinit var instance: AppDatabase
        private set

    override fun init(context: Context): Boolean {
        if (!databaseExists() && !downloadDatabase())
            return false

        initDatabase(context)
        return true
    }

    override fun updateDatabase(context: Context): Boolean {
        if (downloadDatabase()) {
            initDatabase(context)
            return true
        }
        return false
    }

    override fun updateAvailable(): Boolean {
        val version = instance.parameterDao().getParameters.version
        val updateVersion = getUpdateVersion()
        return version < updateVersion
    }

    private fun databaseExists() = File(databaseInfo.path + databaseInfo.name).exists()

    private fun initDatabase(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, databaseInfo.name)
            .build()
            .also { instance = it }

    private fun downloadDatabase(): Boolean {
        return try {
            URL(databaseInfo.link).openStream().use { input ->
                unpackZip(input, databaseInfo.path, databaseInfo.password)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun getUpdateVersion(): Double {
        return try {
            URL(databaseInfo.versionLink).openStream().use { input ->
                val version = input.bufferedReader().use { it.readText() }
                version.toDouble()
            }
        } catch (e: Exception) {
            0.0
        }
    }
}
