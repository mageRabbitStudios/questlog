package com.kinzlstanislav.questlog.base.ktx

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> Fragment.observe(liveData: LiveData<T>, onObserve: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer { onObserve(it) })
}

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, onObserve: (T) -> Unit) {
    liveData.observe(this, Observer { onObserve(it) })
}