package com.kinzlstanislav.questlog.base.ktx

import android.view.ViewGroup
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView

fun BottomNavigationView.removeTooltips() {
    (getChildAt(0) as ViewGroup).forEach { menuItem ->
        menuItem.setOnLongClickListener {
            return@setOnLongClickListener true
        }
        // disable vibration also
        menuItem.isHapticFeedbackEnabled = false
    }
}