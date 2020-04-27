package com.zhukovartemvl.shared.repository

import android.content.Context


interface DatabaseLoader {

    fun init(context: Context): Boolean
    fun updateDatabase(context: Context): Boolean
    fun updateAvailable(): Boolean

}
