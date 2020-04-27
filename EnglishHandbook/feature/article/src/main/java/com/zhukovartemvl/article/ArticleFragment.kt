package com.zhukovartemvl.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.zhukovartemvl.article.databinding.FragmentArticleBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ArticleFragment : Fragment() {

    companion object {
        private const val FRAGMENT_KEY_ID = "FragmentKey"
        fun createBundle(key: String) = Bundle().apply { putString(FRAGMENT_KEY_ID, key) }
    }

    private val fragmentKey: String by lazy {
        arguments?.getString(FRAGMENT_KEY_ID) ?: throw IllegalStateException("no fragmentKey")
    }

    private val articleViewModel: ArticleViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentArticleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_article, container, false
        )
        binding.viewModel = articleViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleViewModel.init(fragmentKey)
    }

}
