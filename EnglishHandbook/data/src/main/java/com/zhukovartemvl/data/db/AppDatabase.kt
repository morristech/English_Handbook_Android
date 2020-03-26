package com.zhukovartemvl.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zhukovartemvl.data.db.dao.*


@Database(
    entities = [ArticleDao::class, DatabaseParametersDao::class,
        DictionaryDao::class, HierarchyDao::class, LinkDao::class, VerbDao::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    abstract fun parameterDao(): DatabaseParametersDao
    abstract fun dictionaryDao(): DictionaryDao
    abstract fun hierarchyDao(): HierarchyDao
    abstract fun linkDao(): LinkDao
    abstract fun verbDao(): VerbDao

}
