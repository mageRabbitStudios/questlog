package com.kinzlstanislav.questlog.base.ktx

import androidx.lifecycle.MutableLiveData

fun MutableLiveData<*>.emit(state: Any) {
    value = state
}