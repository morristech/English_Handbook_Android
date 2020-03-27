package com.zhukovartemvl.englishhandbook.ui.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.englishhandbook.utils.set
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AboutViewModel : ViewModel() {

    val appVersion = MutableLiveData<String>()
    val databaseVersion = MutableLiveData<String>()

    init {
        appVersion.set("1.0.0")
        GlobalScope.launch(Dispatchers.IO) {
            val dbVersion = "1.0"
            withContext(Dispatchers.Main) {
                databaseVersion.set(dbVersion)
            }
        }
    }

    fun onReviewClick() {
    }

    fun onEmailClick() {
    }

}
