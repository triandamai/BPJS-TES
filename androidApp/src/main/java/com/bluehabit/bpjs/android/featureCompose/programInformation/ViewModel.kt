/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.programInformation

import com.bluehabit.bpjs.android.base.BaseViewModel
import com.bluehabit.bpjs.data.domain.data.GetProgramUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProgramInformationViewModel @Inject constructor(
    private val getProgramUseCase: GetProgramUseCase
) : BaseViewModel<ProgramInformationState, ProgramInformationEvent>(ProgramInformationState()) {
    init {
        handleActions()
        getDataProgram()
    }

    private fun getDataProgram() = async {
        getProgramUseCase().collect {
            commit {
                copy(
                    program = it
                )
            }
        }
    }

    override fun handleActions() = onEvent {}

}