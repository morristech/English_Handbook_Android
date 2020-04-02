package com.zhukovartemvl.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.zhukovartemvl.data.db.entity.DictionaryEntity


@Dao
interface DictionaryDao {
    @Query("SELECT * FROM dictionary WHERE key_id = :key")
    fun getByKey(key: String): List<DictionaryEntity>
}
