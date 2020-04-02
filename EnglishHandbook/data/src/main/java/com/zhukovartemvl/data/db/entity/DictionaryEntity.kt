package com.zhukovartemvl.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dictionary")
class DictionaryEntity(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "key_id") var key: String,
    @ColumnInfo(name = "text") var text: String,
    @ColumnInfo(name = "translation") var translation: String
)
