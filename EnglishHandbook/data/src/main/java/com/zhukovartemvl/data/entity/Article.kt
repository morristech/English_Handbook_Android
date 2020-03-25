package com.zhukovartemvl.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "articles")
class Article(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "key_id") var key: String,
    @ColumnInfo(name = "text") var text: String
)
