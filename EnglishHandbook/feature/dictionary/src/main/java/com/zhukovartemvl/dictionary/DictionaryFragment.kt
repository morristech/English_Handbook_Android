package com.zhukovartemvl.dictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zhukovartemvl.dictionary.databinding.FragmentDictionaryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DictionaryFragment : Fragment() {

    companion object {
        private const val FRAGMENT_KEY_ID = "FragmentKey"
        fun createBundle(key: String) = Bundle().apply { putString(FRAGMENT_KEY_ID, key) }
    }

    private val fragmentKey: String by lazy {
        arguments?.getString(FRAGMENT_KEY_ID) ?: throw IllegalStateException("no fragmentKey")
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

    }

}
