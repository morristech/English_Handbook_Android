package com.zhukovartemvl.englishhandbook.adapter.base

import android.view.View


interface BaseAdapterCallback<T> {
    fun onItemClick(model: T, view: View) {}
    fun onLongClick(model: T, view: View): Boolean = true
}
