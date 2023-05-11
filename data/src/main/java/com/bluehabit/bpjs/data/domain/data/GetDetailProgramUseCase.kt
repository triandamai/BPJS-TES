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

class GetDetailProgramUseCase @Inject constructor() {
    operator fun invoke(idProgram:Int?): Flow<Program?> = flow {
        val data = ProgramData.program.firstOrNull {
            it.id == idProgram
        }

        emit(data)
    }.flowOn(Dispatchers.IO)
}