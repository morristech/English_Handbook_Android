package com.zhukovartemvl.domain.interactor

import com.zhukovartemvl.domain.BuildConfig
import com.zhukovartemvl.shared.interactor.AboutInteractor
import com.zhukovartemvl.shared.model.DatabaseParametersItem
import com.zhukovartemvl.shared.repository.DatabaseRepository


class AboutInteractorImpl() : AboutInteractor {

    override fun getAppVersion(): String {
        return BuildConfig.VERSION_NAME
    }

}
