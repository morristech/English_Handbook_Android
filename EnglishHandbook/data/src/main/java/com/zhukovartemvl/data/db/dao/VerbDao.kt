package com.zhukovartemvl.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.zhukovartemvl.data.db.entity.IrregularVerb


@Dao
interface VerbDao {
    @Query("SELECT * FROM irregular_verbs WHERE [key_id] = :key")
    fun getByKey(key: String): List<IrregularVerb>

    @Query("SELECT * FROM irregular_verbs")
    fun getAll(): List<IrregularVerb>
}
