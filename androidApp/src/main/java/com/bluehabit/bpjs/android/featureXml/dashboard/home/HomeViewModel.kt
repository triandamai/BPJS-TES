/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.dashboard.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluehabit.bpjs.data.domain.data.GetHomeProgramUseCase
import com.bluehabit.bpjs.data.domain.data.GetOtherServicesUseCase
import com.bluehabit.bpjs.data.model.Program
import com.bluehabit.bpjs.data.model.Service
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeProgramUseCase: GetHomeProgramUseCase,
    private val getOtherServicesUseCase: GetOtherServicesUseCase
) : ViewModel() {

    init {
        getProgram()
        getServices()
    }

    private val _program: MutableStateFlow<List<Program>> = MutableStateFlow(listOf())
    private val _services: MutableStateFlow<List<Service>> = MutableStateFlow(listOf())

    /**
     * 5000 ms just tricky way to avoid reset state while screen rotate
     * **/
    val program
        get() = _program.asStateFlow()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = listOf()
            )

    val services
        get() = _services.asStateFlow()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = listOf()
            )

    private fun getProgram() = viewModelScope.launch {
        getHomeProgramUseCase().collect {
            _program.tryEmit(it)
        }
    }

    private fun getServices() = viewModelScope.launch {
        getOtherServicesUseCase().collect {
            _services.tryEmit(it)
        }
    }


}