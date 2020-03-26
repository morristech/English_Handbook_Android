package com.zhukovartemvl.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "database_parameters")
class DatabaseParameters(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "version") var version: Double,
    @ColumnInfo(name = "last_update") var lastUpdate: String,
    @ColumnInfo(name = "update_note") var updateNote: String
)
