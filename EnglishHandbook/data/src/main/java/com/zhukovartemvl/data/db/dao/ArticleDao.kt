package com.zhukovartemvl.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.zhukovartemvl.data.db.entity.ArticleEntity


@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles WHERE key_id = :key LIMIT 1")
    fun getByKey(key: String): ArticleEntity
}
