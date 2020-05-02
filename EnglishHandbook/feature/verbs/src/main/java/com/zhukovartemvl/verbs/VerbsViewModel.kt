package com.zhukovartemvl.verbs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.shared.interactor.VerbsInteractor
import com.zhukovartemvl.shared.model.IrregularVerbItem
import com.zhukovartemvl.ui.livedata.set
import com.zhukovartemvl.verbs.adapter.VerbsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class VerbsViewModel(private val verbsInteractor: VerbsInteractor) : ViewModel() {

    val description = MutableLiveData<String>()
    val adapter = VerbsAdapter()

    private var isInitialized = false

    private var verbs: List<IrregularVerbItem> = listOf()

    fun init(key: String, title: String) {
        if (!isInitialized) {
            isInitialized = true

            GlobalScope.launch(Dispatchers.IO) {
                verbs = verbsInteractor.getVerbs(key)

                withContext(Dispatchers.Main) {
                    adapter.updateItems(verbs)
                }
            }
        }

        description.set(newValue = title)
    }


}
