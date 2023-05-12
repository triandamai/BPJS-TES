/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.model

enum class RV_ITEM_TYPE {
    PROGRAM,
    OTHER_SERVICES,
    OTHER
}

data class HomeModel(
    val type: RV_ITEM_TYPE,
    val title: String = "",
    val subtitle: String = ""
)
