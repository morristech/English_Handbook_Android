package com.zhukovartemvl.dictionary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.dictionary.adapter.DictionaryAdapter
import com.zhukovartemvl.shared.interactor.DictionaryInteractor
import com.zhukovartemvl.ui.livedata.set
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DictionaryViewModel(private val dictionaryInteractor: DictionaryInteractor) : ViewModel() {

    val description = MutableLiveData<String>()
    val adapter = DictionaryAdapter()

    private var isInitialized = false

    fun init(key: String, title: String) {
        if (!isInitialized){
            isInitialized = true

            GlobalScope.launch(Dispatchers.IO) {
                val result = dictionaryInteractor.getDictionary(key)

                withContext(Dispatchers.Main) {
                    adapter.updateItems(result)
                }
            }
        }

        description.set(newValue = title)
    }

}
