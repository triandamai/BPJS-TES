/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.splashScreen


import com.bluehabit.bpjs.android.base.BaseViewModelData
import com.bluehabit.bpjs.android.featureCompose.auth.signIn.SignIn
import com.bluehabit.bpjs.data.domain.auth.SignInUseCase
import com.bluehabit.bpjs.data.domain.auth.UserSeederUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val seederUseCase: UserSeederUseCase
) : BaseViewModelData<SplashState, SplashDataState, SplashEvent>(SplashState(), SplashDataState()) {
    init {
        handleActions()
        runSeeder()
    }

    private fun runSeeder() = async {
        seederUseCase().collect()
    }

    override fun handleActions() = onEvent {
        when (it) {
            SplashEvent.CheckSession -> navigateAndReplaceAll(SignIn.routeName)
        }
    }

}