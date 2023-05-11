/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.auth.signIn

import android.util.Patterns
import com.bluehabit.bpjs.android.base.BaseViewModel
import com.bluehabit.bpjs.android.featureCompose.dashboard.home.Home
import com.bluehabit.bpjs.data.domain.auth.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : BaseViewModel<SignInState, SignInEvent>(SignInState()) {

    init {
        handleActions()
    }

    private fun validateData(
        valid: suspend (String, String) -> Unit
    ) = asyncWithState {
        when {
            email.isEmpty() || password.isEmpty() -> {
                showSnackbar("Tidak boleh kosong")
            }

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                showSnackbar("Email tidak cocok")
            }

            else -> valid(email, password)
        }
    }

    override fun handleActions() = onEvent { event ->
        when (event) {
            SignInEvent.SignInWithEmail -> validateData { email, password ->
                signInUseCase(
                    email,
                    password
                )
                    .catch {
                        showSnackbar(it.message.orEmpty())
                    }
                    .onEach {
                        if (it.first) {
                            navigateAndReplaceAll(Home.routeName)
                        }
                    }
                    .collect()
            }

        }
    }
}


