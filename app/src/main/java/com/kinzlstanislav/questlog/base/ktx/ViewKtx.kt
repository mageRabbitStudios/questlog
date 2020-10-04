package com.kinzlstanislav.questlog.base.ktx

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

/**
 * Show soft input keyboard
 */
fun View.showIme() {
    this.requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

fun TextView.setOnDoneClickListener(onClick: () -> Unit) {
    setOnEditorActionListener { _, id, _ ->
        if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_ACTION_NEXT) {
            onClick()
        }
        false
    }
}

/**
 *
 * */
fun <T : View> View.bindView(@IdRes idRes: Int): Lazy<T> {
    return lazy {
        findViewById<T>(idRes)
    }
}

fun <T : View> Activity.bindView(@IdRes idRes: Int): Lazy<T> {
    return lazy {
        findViewById<T>(idRes)
    }
}

fun <T : View> Fragment.bindView(@IdRes idRes: Int): Lazy<T> {
    return lazy {
        requireActivity().findViewById<T>(idRes)
    }
}


fun View.fadeIn(dur: Int, onAnimationEndAction: (() -> Unit)? = null) {
    animate()
        .alphaBy(1f - alpha)
        .setDuration(dur.toLong())
        .withEndAction { onAnimationEndAction?.invoke() }
}

fun View.fadeOut(dur: Int, onAnimationEndAction: (() -> Unit)? = null) {
    animate().alphaBy(-1f)
        .setDuration(dur.toLong())
        .withEndAction { onAnimationEndAction?.invoke() }
}