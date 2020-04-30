package com.zhukovartemvl.article

import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.shared.interactor.ArticleInteractor
import com.zhukovartemvl.ui.livedata.set
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ArticleViewModel(private val articleInteractor: ArticleInteractor) : ViewModel() {

    val text = MutableLiveData<Spanned>()

    fun init(key: String, title: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val article = articleInteractor.getArticle(key)

            val htmlText = HtmlCompat.fromHtml(article.text, HtmlCompat.FROM_HTML_MODE_COMPACT)
            withContext(Dispatchers.Main) {

                text.set(newValue = htmlText)
            }
        }
    }

}
