package com.zhukovartemvl.links

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.ui.livedata.default


class LinksViewModel() : ViewModel() {

    val test = MutableLiveData<String>().default(initialValue = "1.0.0")


}
