package com.zhukovartemvl.about

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukovartemvl.shared.interactor.AboutInteractor
import com.zhukovartemvl.ui.livedata.default
import com.zhukovartemvl.ui.livedata.set


class AboutViewModel(private val aboutInteractor: AboutInteractor) : ViewModel() {

    val appVersion = MutableLiveData<String>()

    init {
        appVersion.set(newValue = BuildConfig.VERSION_NAME)
    }

    fun onEmailClick(context: Context) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_EMAIL, arrayOf(context.getString(R.string.email)))
            putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.email_subject))
            putExtra(Intent.EXTRA_TEXT, context.getString(R.string.email_text))
            type = "message/rfc822x"
        }
        val intentChooser =
            Intent.createChooser(intent, context.getString(R.string.email_popup_title))
        context.startActivity(intentChooser.apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) })
    }

}
