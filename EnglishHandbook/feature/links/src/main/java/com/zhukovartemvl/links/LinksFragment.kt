package com.zhukovartemvl.links

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zhukovartemvl.links.databinding.FragmentLinksBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LinksFragment : Fragment() {

    companion object {
        private const val FRAGMENT_KEY_ID = "FragmentKey"
        fun createBundle(key: String) = Bundle().apply { putString(FRAGMENT_KEY_ID, key) }
    }

    private val fragmentKey: String by lazy {
        arguments?.getString(FRAGMENT_KEY_ID) ?: throw IllegalStateException("no fragmentKey")
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


    }

}
