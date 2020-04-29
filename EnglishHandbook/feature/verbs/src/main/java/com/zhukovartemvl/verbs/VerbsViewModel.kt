package com.zhukovartemvl.verbs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.ui.livedata.default


class VerbsViewModel(): ViewModel() {

    val test = MutableLiveData<String>().default(initialValue = "1.0.0")

}
