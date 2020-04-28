package com.zhukovartemvl.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.englishhandbook.home.navigation.HomeNavigation
import com.zhukovartemvl.shared.interactor.AboutInteractor
import com.zhukovartemvl.shared.interactor.DatabaseInteractor
import com.zhukovartemvl.ui.livedata.default
import com.zhukovartemvl.ui.livedata.set
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel(
    private val navigation: HomeNavigation,
    private val aboutInteractor: AboutInteractor,
    private val databaseInteractor: DatabaseInteractor
) : ViewModel() {

    val state = MutableLiveData<HomeState>().default(initialValue = HomeState.LoadingDatabaseState)

    val loadingStatus = MutableLiveData<String>()

    fun init(context: Context) {

        loadingStatus.set(newValue = "Загрузка Базы Данных")
        GlobalScope.launch(Dispatchers.IO) {
            val result = databaseInteractor.init(context)

            withContext(Dispatchers.Main) {
                if (result) {
                    state.set(newValue = HomeState.DefaultState)
                    initCategories()
                } else {
                    state.set(newValue = HomeState.DatabaseLoadingErrorState)
                    loadingStatus.set(newValue = "Ошибка")
                }
            }

//            if (result){
//                val dbVersion = aboutInteractor.getDatabaseParameters().version
//                withContext(Dispatchers.Main) {
//                    loadingStatus.set(newValue = "Версия БД $dbVersion")
//                }
//            }

        }
    }

    private fun initCategories() {
        GlobalScope.launch(Dispatchers.IO) {
            val dbVersion = aboutInteractor.getDatabaseParameters().version
            withContext(Dispatchers.Main) {
                loadingStatus.set(newValue = "Версия БД $dbVersion")
            }
        }
    }

    fun openArticle() {
        navigation.openArticle("Adfasdasdsad")
    }

    //...

    fun openAbout() {
        navigation.openArticle("Adfasdasdsad")
    }
}
