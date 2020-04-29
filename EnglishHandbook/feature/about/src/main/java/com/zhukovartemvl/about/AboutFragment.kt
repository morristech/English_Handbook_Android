package com.zhukovartemvl.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zhukovartemvl.about.databinding.FragmentAboutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AboutFragment : Fragment() {

    private val aboutViewModel: AboutViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAboutBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_about, container, false
        )
        binding.viewModel = aboutViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}
