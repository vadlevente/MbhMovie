package com.mbh.moviebrowser.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

abstract class ViewModelBase : ViewModel() {

    private val whileViewSubscribed: SharingStarted = SharingStarted.WhileSubscribed(StopTimeoutMillis)

    fun <T> Flow<T>.asState(defaultValue: T) = stateIn(viewModelScope, whileViewSubscribed, defaultValue)

    companion object {
        private const val StopTimeoutMillis: Long = 5000
    }

}