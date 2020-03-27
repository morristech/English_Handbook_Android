package com.zhukovartemvl.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.zhukovartemvl.data.db.entity.Link


@Dao
interface LinkDao {
    @Query("SELECT * FROM links WHERE key_id = :key")
    fun getByKey(key: String): List<Link>
}
