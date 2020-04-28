package com.zhukovartemvl.shared.interactor

import android.content.Context


interface DatabaseInteractor {

    fun init(context: Context) : Boolean
    fun initAndCheckUpdate(context: Context) : Boolean

}
