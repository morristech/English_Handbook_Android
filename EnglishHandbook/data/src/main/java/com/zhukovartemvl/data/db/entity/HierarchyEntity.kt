package com.zhukovartemvl.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "hierarchy")
class HierarchyEntity(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "parent_id") var parentId: Int,
    @ColumnInfo(name = "key_id") var key: String,
    @ColumnInfo(name = "type") var type: Int,
    @ColumnInfo(name = "text") var text: String
)

