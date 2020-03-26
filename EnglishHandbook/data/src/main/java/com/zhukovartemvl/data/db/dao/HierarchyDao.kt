package com.zhukovartemvl.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.zhukovartemvl.data.db.entity.HierarchyItem


@Dao
interface HierarchyDao {
    @Query("SELECT * FROM hierarchy WHERE [parent_id] = :parentId")
    fun getAllChildren(parentId: Int): List<HierarchyItem>
}
