/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.dashboard.home

import com.bluehabit.bpjs.android.base.BaseViewModelData
import com.bluehabit.bpjs.data.domain.data.GetHomeProgramUseCase
import com.bluehabit.bpjs.data.domain.data.GetOtherServicesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeProgramUseCase: GetHomeProgramUseCase,
    private val getOtherServicesUseCase: GetOtherServicesUseCase
) : BaseViewModelData<HomeState, HomeDataState, HomeEvent>(HomeState(), HomeDataState()) {
    init {
        handleActions()
        getHomeData()
    }

    private fun getHomeData() = async {
        getHomeProgramUseCase().collect {
            commitData {
                copy(
                    programs = it
                )
            }
        }

        getOtherServicesUseCase().collect {
            commitData {
                copy(
                    services = it
                )
            }
        }
    }

    override fun handleActions() = onEvent {
        when (it) {
            is HomeEvent.SetName -> Unit
        }
    }
}