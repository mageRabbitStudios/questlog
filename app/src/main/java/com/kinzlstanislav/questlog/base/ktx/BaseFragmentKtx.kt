package com.kinzlstanislav.questlog.base.ktx

import android.app.Activity
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.kinzlstanislav.questlog.base.BaseFragment

fun BaseFragment.toast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(requireContext(), message, length).show()
}

fun BaseFragment.hideKeyboard() {
    val inputManager =
        requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
}

fun BaseFragment.navigate(directions: NavDirections) {
    findNavController().navigate(directions)
}

fun BaseFragment.navigateUp() {
    findNavController().navigateUp()
}

fun BaseFragment.disableTouchGestures() {
    requireActivity().window.setFlags(
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
    )
}

fun BaseFragment.enableTouchGestures() {
    requireActivity().window.clearFlags(
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
    )
}