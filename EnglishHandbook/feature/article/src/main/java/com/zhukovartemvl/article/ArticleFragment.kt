package com.zhukovartemvl.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_article.*


class ArticleFragment : Fragment() {

    companion object {
        private const val ARTICLE_KEY_ID = "ArticleKey"

        fun createBundle(key: String) =
            Bundle().apply {
                putString(ARTICLE_KEY_ID, key)
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    private val articleKey: String by lazy {
        arguments?.getString(ARTICLE_KEY_ID) ?: throw IllegalStateException("no articleKey")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleKeyText.text = articleKey
    }

}
