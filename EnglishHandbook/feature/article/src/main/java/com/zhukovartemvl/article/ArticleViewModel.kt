package com.zhukovartemvl.article

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.ui.livedata.set


class ArticleViewModel() : ViewModel() {

    var test = MutableLiveData<String>()

    fun init(key: String) {
        test.set(newValue = key)
    }

}
