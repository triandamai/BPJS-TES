/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.detailProgram

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluehabit.bpjs.data.domain.data.GetDetailProgramUseCase
import com.bluehabit.bpjs.data.model.Program
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailProgramViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getDetailProgramUseCase: GetDetailProgramUseCase
) : ViewModel() {
    init {
        val id = savedStateHandle.get<Int>("ID")
        getDetailProgram(id)
    }

    private val _program: MutableStateFlow<Program?> = MutableStateFlow(null)
    private val _list: MutableStateFlow<List<String>> = MutableStateFlow(listOf())
    var isBenefit: Boolean = false

    val program
        get() = _program.asStateFlow()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = null
            )

    val list
        get() = _list.asStateFlow()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = listOf()
            )


    private fun getDetailProgram(id: Int?) = viewModelScope.launch {
        getDetailProgramUseCase(id).collect {
            _program.tryEmit(it)
            if (isBenefit) {
                _list.tryEmit(it?.benefit.orEmpty())
            } else {
                _list.tryEmit(it?.contribution.orEmpty())
            }
        }
    }

    fun update(benefit:Boolean)=viewModelScope.launch {
        isBenefit=benefit
        if (benefit) {
            _list.tryEmit(_program.value?.benefit.orEmpty())
        } else {
            _list.tryEmit(_program.value?.contribution.orEmpty())
        }
    }
}