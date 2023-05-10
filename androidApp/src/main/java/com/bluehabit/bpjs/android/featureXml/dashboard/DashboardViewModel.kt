package com.bluehabit.bpjs.android.featureXml.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class DashboardViewModel : ViewModel() {


    private val _text: MutableStateFlow<String> = MutableStateFlow("")

    /**
     * 5000 ms just tricky way to avoid reset state while screen rotate
     * **/
    val uiState
        get() = _text.asStateFlow()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = ""
            )
}