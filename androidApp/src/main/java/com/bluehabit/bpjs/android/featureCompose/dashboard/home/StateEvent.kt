/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.dashboard.home

import android.os.Parcelable
import com.bluehabit.bpjs.data.model.Program
import com.bluehabit.bpjs.data.model.Service
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.time.LocalDateTime
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class HomeState(
    val showBalance: Boolean = true
) : Parcelable

@Immutable
@Parcelize
data class HomeDataState(
    val programs: @RawValue List<Program> = listOf(),
    val services: @RawValue List<Service> = listOf()
) : Parcelable

sealed class HomeEvent {
    class SetName(var name: String) : HomeEvent()
}