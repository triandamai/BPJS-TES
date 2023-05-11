/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.detailProgram

import android.os.Parcelable
import com.bluehabit.bpjs.data.model.Program
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class DetailProgramState(
    val a: String = ""
) : Parcelable

@Immutable
@Parcelize
data class DetailProgramDataState(
    val program: @RawValue Program? = null
) : Parcelable

sealed interface DetailProgramEvent {
}