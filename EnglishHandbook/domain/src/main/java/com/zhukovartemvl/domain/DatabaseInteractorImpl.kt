package com.zhukovartemvl.domain

import android.content.Context
import com.zhukovartemvl.shared.interactor.DatabaseInteractor
import com.zhukovartemvl.shared.repository.DatabaseRepository


class DatabaseInteractorImpl(private val repository: DatabaseRepository) : DatabaseInteractor {

    override fun init(context: Context): Boolean {
        return repository.initDatabase(context)
    }

    override fun initAndCheckUpdate(context: Context): Boolean {
        return if (repository.updateAvailable())
            repository.updateDatabase(context)
        else
            repository.initDatabase(context)
    }

}
