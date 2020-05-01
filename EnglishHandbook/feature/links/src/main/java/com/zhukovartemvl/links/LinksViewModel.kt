package com.zhukovartemvl.links

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.links.abapter.LinksAdapter
import com.zhukovartemvl.shared.interactor.LinksInteractor
import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.ui.base.adapter.BaseAdapterCallback
import com.zhukovartemvl.ui.livedata.set
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LinksViewModel(private val linksInteractor: LinksInteractor) : ViewModel() {

    val description = MutableLiveData<String>()

    val adapter = LinksAdapter()

    private var isInitialized = false

    fun init(key: String, title: String) {
        if (!isInitialized) {
            isInitialized = true

            GlobalScope.launch(Dispatchers.IO) {
                val result = linksInteractor.getLinks(key)

                withContext(Dispatchers.Main) {
                    adapter.updateItems(result)
                }
            }
        }

        description.set(newValue = title)
    }

    init {
        adapter.attachCallback(object : BaseAdapterCallback<LinkItem> {
            override fun onItemClick(model: LinkItem, view: View) {
                val context = view.context

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(model.link)).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intent)
            }
        })
    }
}
