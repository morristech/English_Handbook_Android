package com.zhukovartemvl.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.zhukovartemvl.data.db.entity.DatabaseParameters


@Dao
interface DatabaseParametersDao {
    @get:Query("SELECT * FROM database_parameters WHERE id = 1 LIMIT 1")
    val getParameters: DatabaseParameters
}
