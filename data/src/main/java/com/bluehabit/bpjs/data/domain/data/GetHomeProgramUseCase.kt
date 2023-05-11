/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.domain.data

import com.bluehabit.bpjs.data.model.Program
import com.bluehabit.bpjs.data.remote.ProgramData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetHomeProgramUseCase @Inject constructor() {
    operator fun invoke(): Flow<List<Program>> = flow {
        val data = ProgramData.program.filter {
            it.available
        }.take(2)
        emit(data)
    }.flowOn(Dispatchers.IO)
}