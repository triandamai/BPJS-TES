/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.bluehabit.bpjs.android.featureCompose.auth.signIn.routeSignIn
import com.bluehabit.bpjs.android.featureCompose.dashboard.home.routeHome
import com.bluehabit.bpjs.android.featureCompose.detailProgram.routeDetailProgram
import com.bluehabit.bpjs.android.featureCompose.programInformation.routeProgramInformation
import com.bluehabit.bpjs.android.featureCompose.splashScreen.Splash
import com.bluehabit.bpjs.android.featureCompose.splashScreen.routeSplash

@Composable
fun AppNavigation(
    applicationState: ApplicationState
) {
    NavHost(
        navController = applicationState.router,
        startDestination = Splash.routeName
    ) {
        routeSplash(
            state = applicationState
        )
        routeSignIn(
            state = applicationState
        )
        routeHome(
            state = applicationState
        )
        routeProgramInformation(
            state = applicationState
        )
        routeDetailProgram(
            state = applicationState

        )
    }
}