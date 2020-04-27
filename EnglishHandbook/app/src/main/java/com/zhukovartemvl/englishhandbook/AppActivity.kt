package com.zhukovartemvl.englishhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.zhukovartemvl.englishhandbook.di.getKoinInstance
import com.zhukovartemvl.englishhandbook.home.HomeNavigation
import com.zhukovartemvl.englishhandbook.navigation.Navigator
import com.zhukovartemvl.ui.base.navigator.BaseNav
import kotlinx.android.synthetic.main.activity_app.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class AppActivity : AppCompatActivity() {

    private val appViewModel: AppViewModel by viewModel()

    private val homeNavigation by lazy { getKoinInstance<HomeNavigation>() }
    private val navigator by lazy { getKoinInstance<BaseNav>() }

    private val navController by lazy(LazyThreadSafetyMode.NONE) {
        Navigation.findNavController(this, R.id.navHostMain)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        setupNavigation()
    }

    private fun setupNavigation() {
//        setSupportActionBar(toolbar)
//        setActionBar(toolbar)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val version = getString(R.string.version) + ": " + BuildConfig.VERSION_NAME
        nav_view.getHeaderView(0).findViewById<TextView>(R.id.navAppVersion).text = version

        NavigationUI.setupWithNavController(toolbar, navController, drawer_layout)
        NavigationUI.setupWithNavController(nav_view, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment) {
                drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
//                actionBar?.setDisplayHomeAsUpEnabled(true)
//                actionBar?.setDisplayShowHomeEnabled(true)
            } else {
//                if (destination.id == R.id.datesFragment)
//                    appViewModel.showInterstitialAd()
                drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
//                actionBar?.setDisplayHomeAsUpEnabled(false)
//                actionBar?.setDisplayShowHomeEnabled(false)
            }
        }
        toolbar.setNavigationOnClickListener {
            if (navController.currentDestination?.id == R.id.homeFragment)
                drawer_layout.openDrawer(GravityCompat.START)
            else
                onBackPressed()
        }
        nav_view.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_share -> {
                }
                R.id.nav_rate -> {
                }
                R.id.nav_about -> homeNavigation.openArticle(key = "RELORELORELO")
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
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
