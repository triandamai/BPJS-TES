/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.domain.auth

import com.bluehabit.bpjs.data.common.Response
import com.bluehabit.bpjs.data.remote.auth.AuthDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SignInWIthGoogleUseCase @Inject constructor(
    private val authDataSource: AuthDataSource
) {
    operator fun invoke(token: String?) = flow {
        emit(Response.Loading)
        val result = authDataSource.signInWithGoogle(token.orEmpty())
        emit(result)
    }.flowOn(Dispatchers.IO)
}