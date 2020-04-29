package com.zhukovartemvl.about

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.ui.livedata.default


class AboutViewModel() : ViewModel() {

    val appVersion = MutableLiveData<String>().default(initialValue = "1.0.0")
    val databaseVersion = MutableLiveData<String>().default(initialValue = "1.0.0")

    fun onEmailClick() {

    }

    fun onReviewClick() {

    }

}
