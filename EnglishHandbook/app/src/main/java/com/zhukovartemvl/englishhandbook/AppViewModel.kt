package com.zhukovartemvl.englishhandbook

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.android.gms.ads.*


class AppViewModel(context: Context) : ViewModel() {

    private var interstitialAd = InterstitialAd(context)

    private var intAdShowCount = 0
    private val intAdPeriodicity = 5

    private val adRequest: AdRequest
        get() = AdRequest.Builder().build()

    init {
        val requestConfiguration = RequestConfiguration.Builder()
            .setTestDeviceIds(
                context.resources.getStringArray(R.array.addTestDevices).toMutableList()
            ).build()
        MobileAds.setRequestConfiguration(requestConfiguration)

        interstitialAd.adUnitId = context.getString(R.string.ad_interstitial_unit_id)

        interstitialAd.adListener = object : AdListener() {
            override fun onAdClicked() {}
            override fun onAdLeftApplication() {}
            override fun onAdClosed() {
                interstitialAd.loadAd(adRequest)
            }
        }

        interstitialAd.loadAd(adRequest)
    }

    fun showInterstitial() {
        if (interstitialAd.isLoaded) {
            if (intAdShowCount % intAdPeriodicity == 0) {
                interstitialAd.show()
                intAdShowCount = 0
            }
            intAdShowCount++
        }
    }

    fun loadBanner(): AdRequest {
        return adRequest
    }

}
