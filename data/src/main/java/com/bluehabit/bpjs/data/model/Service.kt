/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.model

import com.bluehabit.bpjs.data.R

data class Service(
    val id: Int = 0,
    val serviceName: String = "",
    val serviceIcon: Int = androidx.core.R.drawable.notification_action_background
)
