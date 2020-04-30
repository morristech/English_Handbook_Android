package com.zhukovartemvl.home

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.zhukovartemvl.englishhandbook.home.R
import com.zhukovartemvl.englishhandbook.home.databinding.FragmentHomeBinding
import com.zhukovartemvl.ui.IOnBackPressed
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(), IOnBackPressed {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        binding.viewModel = homeViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryList.adapter = homeViewModel.adapter

        homeViewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is HomeState.DefaultState -> {
                    categoryList.visibility = View.VISIBLE
                    databaseUpdateState.visibility = View.GONE
                }
                is HomeState.LoadingDatabaseState -> {
                    databaseUpdateState.visibility = View.VISIBLE
                    categoryList.visibility = View.GONE
                }
                is HomeState.DatabaseLoadingErrorState -> {

                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.aboutButton -> homeViewModel.openAbout()
        }
        return false
    }

    override fun onBackPressed(): Boolean {
        return homeViewModel.onBack()
    }

}
