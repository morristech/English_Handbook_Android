package com.zhukovartemvl.englishhandbook.utils

import android.content.Context
import com.zhukovartemvl.englishhandbook.R
import java.io.File

class DatabaseLoader(context: Context) {
    private val dbName = context.getString(R.string.database_name)
    private val dbZipName = context.getString(R.string.database_zip_name)
    private val dbPath = "${context.applicationInfo.dataDir}/databases/"

    var instance: AppDatabase = getDatabase(context)
        private set

    @Synchronized
    private fun getDatabase(context: Context): AppDatabase {
        if (!File(dbPath + dbName).exists()) {
            val inputStream = context.assets.open(dbZipName)
            unpackZip(dbPath, inputStream)
        }
        return Room.databaseBuilder(
            context.applicationContext, AppDatabase::class.java, dbName
        ).build().also { instance = it }
    }

}
