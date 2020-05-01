package com.zhukovartemvl.dictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zhukovartemvl.dictionary.databinding.FragmentDictionaryBinding
import kotlinx.android.synthetic.main.fragment_dictionary.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class DictionaryFragment : Fragment() {

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

    private val dictionaryViewModel: DictionaryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDictionaryBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dictionary, container, false
        )
        binding.viewModel = dictionaryViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dictionaryViewModel.init(fragmentKey, fragmentTitle)

        dictionaryList.adapter = dictionaryViewModel.adapter
    }

}
