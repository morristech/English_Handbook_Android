package com.zhukovartemvl.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "irregular_verbs")
class IrregularVerbEntity(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "key_id") var key: String,
    @ColumnInfo(name = "type") var type: Int,
    @ColumnInfo(name = "rate") var rate: Int,
    @ColumnInfo(name = "first_form") var firstForm: String,
    @ColumnInfo(name = "second_form") var secondForm: String,
    @ColumnInfo(name = "third_form") var thirdForm: String,
    @ColumnInfo(name = "translation") var translation: String
)
