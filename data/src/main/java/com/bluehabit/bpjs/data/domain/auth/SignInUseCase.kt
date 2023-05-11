/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.domain.auth

import com.bluehabit.bpjs.data.local.SharedPref
import com.bluehabit.bpjs.db.BpjsDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val db: BpjsDatabase
) {
    operator fun invoke(email: String, password: String): Flow<Pair<Boolean, String>> = flow {
        val findData = db.userQueries.getUserByEmail(
            email
        ).executeAsOneOrNull() ?: throw Exception("User Not found")

        if (findData.userPassword != password) throw Exception("Login gagal")

        emit(Pair(true, "Berhasil"))

    }.flowOn(Dispatchers.IO)
}