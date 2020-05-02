package com.zhukovartemvl.verbs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zhukovartemvl.verbs.databinding.FragmentVerbsBinding
import kotlinx.android.synthetic.main.fragment_verbs.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class VerbsFragment : Fragment() {

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

    private val verbsViewModel: VerbsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentVerbsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_verbs, container, false
        )
        binding.viewModel = verbsViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        verbsViewModel.init(fragmentKey, fragmentTitle)

        verbsList.adapter = verbsViewModel.adapter
    }

}
