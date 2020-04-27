package com.zhukovartemvl.loading

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zhukovartemvl.loading.databinding.FragmentLoadingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoadingFragment : Fragment() {

    private val loadingViewModel: LoadingViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoadingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_loading, container, false
        )
        binding.viewModel = loadingViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}
