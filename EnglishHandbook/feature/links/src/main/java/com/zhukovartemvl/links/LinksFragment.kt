package com.zhukovartemvl.links

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class LinksFragment : Fragment() {

    companion object {
        private const val LINKS_KEY_ID = "LinksKey"

        fun createBundle(key: String) =
            Bundle().apply {
                putString(LINKS_KEY_ID, key)
            }
    }

    private val linksKey: String by lazy {
        arguments?.getString(LINKS_KEY_ID) ?: throw IllegalStateException("no linksKey")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_links, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linksKey
    }

}
