package com.kinzlstanislav.questlog.base.ktx

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

typealias Coroutine = Job

fun ViewModel.coroutine(
    dispatcher: CoroutineDispatcher = Dispatchers.Main,
    block: suspend CoroutineScope.() -> Unit
): Coroutine = viewModelScope.launch(dispatcher) {
    block()
    cancel()
}