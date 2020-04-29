package com.zhukovartemvl.englishhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.zhukovartemvl.englishhandbook.di.getKoinInstance
import com.zhukovartemvl.ui.base.navigator.BaseNavigator
import kotlinx.android.synthetic.main.activity_app.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class AppActivity : AppCompatActivity() {

    private val appViewModel: AppViewModel by viewModel()

    private val navigator by lazy { getKoinInstance<BaseNavigator>() }

    private val navController by lazy { Navigation.findNavController(this, R.id.navHostMain) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(toolbar, navController)

        adBannerView.loadAd(appViewModel.loadBanner())

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id != R.id.aboutFragment ||
                destination.id != R.id.homeFragment
            ) {
                appViewModel.showInterstitial()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        navigator.bind(findNavController(R.id.navHostMain))
    }

    override fun onPause() {
        super.onPause()
        navigator.unbind()
    }

}
