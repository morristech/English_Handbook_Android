package com.zhukovartemvl.home

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.englishhandbook.home.R
import com.zhukovartemvl.home.adapter.HierarchyAdapter
import com.zhukovartemvl.home.navigation.HomeNavigation
import com.zhukovartemvl.shared.interactor.CategoryInteractor
import com.zhukovartemvl.shared.interactor.DatabaseInteractor
import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.ui.base.adapter.BaseAdapterCallback
import com.zhukovartemvl.ui.livedata.default
import com.zhukovartemvl.ui.livedata.set
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel(
    context: Context,
    private val navigation: HomeNavigation,
    private val categoryInteractor: CategoryInteractor,
    private val databaseInteractor: DatabaseInteractor
) : ViewModel() {

    val state = MutableLiveData<HomeState>().default(initialValue = HomeState.LoadingDatabaseState)
    val adapter = HierarchyAdapter()
    val loadingStatus = MutableLiveData<String>()

    init {
        loadingStatus.set(newValue = context.getString(R.string.database_load))
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
            val newCategories = categoryInteractor.loadRootCategories()
            withContext(Dispatchers.Main) {
                adapter.updateItems(newCategories)
            }
        }

        adapter.attachCallback(object : BaseAdapterCallback<Category> {
            override fun onItemClick(model: Category, view: View) {
                when (model) {
                    is BackItem -> GlobalScope.launch(Dispatchers.IO) {
                        val newCategories = categoryInteractor.categoryBack(model)
                        withContext(Dispatchers.Main) {
                            adapter.updateItems(newCategories)
                        }
                    }
                    is Folder -> GlobalScope.launch(Dispatchers.IO) {
                        val newCategories = categoryInteractor.openFolder(model)
                        withContext(Dispatchers.Main) {
                            adapter.updateItems(newCategories)
                        }
                    }
                    is Article -> navigation.openArticle(model.key)
                    is IrregularVerbs -> navigation.openVerbs(model.key)
                    is Dictionary -> navigation.openDictionary(model.key)
                    is Links -> navigation.openLinks(model.key)
                }
            }
        })
    }

    fun onBack(): Boolean {
        if (categoryInteractor.isRootFolder())
            return false
        GlobalScope.launch(Dispatchers.IO) {
            val newCategories = categoryInteractor.categoryBack()
            withContext(Dispatchers.Main) {
                adapter.updateItems(newCategories)
            }
        }
        return true
    }

    fun openAbout() {
        navigation.openAbout()
    }

}
