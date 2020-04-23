package com.zhukovartemvl.verbs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class VerbsFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_verbs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dictionaryKey
    }

}
