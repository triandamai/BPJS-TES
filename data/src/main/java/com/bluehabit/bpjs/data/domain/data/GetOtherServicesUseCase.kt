/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.domain.data

import com.bluehabit.bpjs.data.local.SharedPref
import com.bluehabit.bpjs.data.model.Service
import com.bluehabit.bpjs.data.remote.ProgramData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetOtherServicesUseCase @Inject constructor() {
    operator fun invoke(): Flow<List<Service>> = flow {
        val data = ProgramData.service
        emit(data)
    }.flowOn(Dispatchers.IO)
}