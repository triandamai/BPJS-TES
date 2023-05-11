/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.domain.auth

import android.content.SharedPreferences.Editor
import com.bluehabit.bpjs.data.local.SharedPref
import com.bluehabit.bpjs.db.BpjsDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDate
import java.util.UUID
import javax.inject.Inject

class UserSeederUseCase @Inject constructor(
    private val pref: SharedPref,
    private val db: BpjsDatabase
) {
    operator fun invoke(): Flow<Boolean> = flow {
        if (pref.getFirstRun()) {
            db.userQueries.insertUser(
                userId = UUID.randomUUID().toString(),
                userEmail = "triandamai@gmail.com",
                userPassword = "triandamai",
                userFullName = "Trian Damai",
                createdAt = "",
                updatedAt = "",
            )
        }
        emit(true)
    }.flowOn(Dispatchers.IO)
}