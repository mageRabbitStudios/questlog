package com.kinzlstanislav.questlog.base.ktx

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.requireDrawable(@DrawableRes resId: Int): Drawable? = ContextCompat.getDrawable(this, resId)
fun Context.requireColor(@ColorRes resId: Int): Int = ContextCompat.getColor(this, resId)