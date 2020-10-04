package com.kinzlstanislav.questlog.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val showBottomNavbarState = MutableLiveData<Boolean>(false)
}