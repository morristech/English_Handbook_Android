package com.zhukovartemvl.dictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class DictionaryFragment : Fragment() {

    companion object {
        private const val DICTIONARY_KEY_ID = "DictionaryKey"

        fun createBundle(key: String) =
            Bundle().apply {
                putString(DICTIONARY_KEY_ID, key)
            }
    }

    private val dictionaryKey: String by lazy {
        arguments?.getString(DICTIONARY_KEY_ID) ?: throw IllegalStateException("no dictionaryKey")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dictionary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dictionaryKey
    }

}
