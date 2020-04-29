package com.zhukovartemvl.dictionary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.ui.livedata.default


class DictionaryViewModel() : ViewModel() {

    val test = MutableLiveData<String>().default(initialValue = "1.0.0")


}
