/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.android.feature.resultCreateBudget

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class ResultCreateBudgetState(
    val a: String = ""
) : Parcelable

@Immutable
@Parcelize
data class ResultCreateBudgetDataState(
    val a: String = ""
) : Parcelable

sealed class ResultCreateBudgetEvent {
}