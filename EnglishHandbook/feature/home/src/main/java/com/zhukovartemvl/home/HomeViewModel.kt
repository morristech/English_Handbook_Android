package com.zhukovartemvl.home

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.home.adapter.HierarchyAdapter
import com.zhukovartemvl.home.navigation.HomeNavigation
import com.zhukovartemvl.shared.interactor.CategoryInteractor
import com.zhukovartemvl.shared.interactor.DatabaseInteractor
import com.zhukovartemvl.shared.model.BackItem
import com.zhukovartemvl.shared.model.Category
import com.zhukovartemvl.ui.base.adapter.BaseAdapterCallback
import com.zhukovartemvl.ui.livedata.default
import com.zhukovartemvl.ui.livedata.set
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel(
    private val navigation: HomeNavigation,
    private val categoryInteractor: CategoryInteractor,
    private val databaseInteractor: DatabaseInteractor
) : ViewModel() {

    val state = MutableLiveData<HomeState>().default(initialValue = HomeState.LoadingDatabaseState)
    val adapter = HierarchyAdapter()
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

        }
    }

    private fun initCategories() {
        GlobalScope.launch(Dispatchers.IO) {

            withContext(Dispatchers.Main) {

            }
        }
        adapter.attachCallback(object : BaseAdapterCallback<Category> {
            override fun onItemClick(model: Category, view: View) {
                when (model) {
                    is BackItem -> GlobalScope.launch(Dispatchers.IO) {

                    }

                }
            }
        })
    }

    //...

    fun openAbout() {
        navigation.openArticle("Adfasdasdsad")
    }
}
