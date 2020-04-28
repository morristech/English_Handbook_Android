package com.zhukovartemvl.shared.interactor

import com.zhukovartemvl.shared.model.DatabaseParametersItem


interface AboutInteractor {

    fun getAppVersion(): String
    fun getDatabaseParameters(): DatabaseParametersItem

}
