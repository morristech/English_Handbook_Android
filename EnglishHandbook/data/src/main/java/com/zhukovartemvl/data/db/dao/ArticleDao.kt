package com.zhukovartemvl.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.zhukovartemvl.data.db.entity.Article


@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles WHERE key_id = :key")
    fun getByKey(key: String): List<Article>
}
