/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.detailProgram

import androidx.lifecycle.SavedStateHandle
import com.bluehabit.bpjs.android.base.BaseViewModelData
import com.bluehabit.bpjs.data.domain.data.GetDetailProgramUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailProgramViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getDetailProgramUseCase: GetDetailProgramUseCase
) : BaseViewModelData<DetailProgramState, DetailProgramDataState, DetailProgramEvent>(DetailProgramState(), DetailProgramDataState()) {
    init {
        handleActions()
        val id = savedStateHandle.get<Int>(DetailProgram.argKey)?.or(0)
        getDetail(id)

    }

    private fun getDetail(id: Int?)=async {
        getDetailProgramUseCase(id).collect {
            commitData {
                copy(
                    program = it
                )
            }
        }
    }

    override fun handleActions() = onEvent {}

}