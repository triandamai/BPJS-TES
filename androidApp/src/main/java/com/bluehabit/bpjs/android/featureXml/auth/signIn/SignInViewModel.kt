/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.auth.signIn

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluehabit.bpjs.data.domain.auth.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {
    fun signIn(email: String, password: String, callback: (Boolean, String) -> Unit) = viewModelScope.launch {
        if (validate(email, password)) {
            signInUseCase(email, password)
                .onEach {
                    callback(it.first, it.second)
                }
                .catch {
                    callback(false, it.message.orEmpty())
                }
                .collect()
        } else {
            callback(false, "Data tidak valid")
        }

    }

    private fun validate(email: String, password: String): Boolean {
        if (email.isEmpty() || password.isEmpty()) return false
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) return false
        return true
    }
}