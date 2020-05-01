package com.zhukovartemvl.links

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zhukovartemvl.links.databinding.FragmentLinksBinding
import kotlinx.android.synthetic.main.fragment_links.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class LinksFragment : Fragment() {

    companion object {
        private const val FRAGMENT_KEY_ID = "key"
        private const val FRAGMENT_TITLE = "title"
        fun createBundle(key: String, title: String) = Bundle().apply {
            putString(FRAGMENT_KEY_ID, key)
            putString(FRAGMENT_TITLE, title)
        }
    }

    private val fragmentKey: String by lazy {
        arguments?.getString(FRAGMENT_KEY_ID) ?: throw IllegalStateException("no fragmentKey")
    }

    private val fragmentTitle: String by lazy {
        arguments?.getString(FRAGMENT_TITLE) ?: throw IllegalStateException("no fragmentTitle")
    }

    private val linksViewModel: LinksViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLinksBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_links, container, false
        )
        binding.viewModel = linksViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linksViewModel.init(fragmentKey, fragmentTitle)

        linksList.adapter = linksViewModel.adapter
    }

}
