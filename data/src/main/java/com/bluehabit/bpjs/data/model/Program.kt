/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.model

import com.bluehabit.bpjs.data.R

data class Program(
    val id: Int = 0,
    val title: String = "",
    val subtitle: String = "",
    val icon: Int = androidx.core.R.drawable.notification_action_background,
    val available: Boolean = false,
    val description: String = "",
    val benefit: List<String> = listOf(),
    val contribution: List<String> = listOf()
)
