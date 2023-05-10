/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.dashboard.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.ApplicationState
import com.bluehabit.bpjs.android.base.BaseMainApp
import com.bluehabit.bpjs.android.base.UIWrapper
import com.bluehabit.bpjs.android.base.extensions.bottomNavigationListener
import com.bluehabit.bpjs.android.base.extensions.formatToRupiah
import com.bluehabit.bpjs.android.base.extensions.gridItems
import com.bluehabit.bpjs.android.base.extensions.navigateSingleTop
import com.bluehabit.bpjs.android.base.listener.BottomNavigationListener
import com.bluehabit.bpjs.android.components.DashboardBottomNavigation
import com.bluehabit.bpjs.android.components.DashboardBottomNavigationMenu
import com.bluehabit.bpjs.android.rememberApplicationState

object Home {
    const val routeName = "Home"
}

fun NavGraphBuilder.routeHome(
    state: ApplicationState
) {
    composable(Home.routeName) {
        ScreenHome(appState = state)

    }
}

@Composable
internal fun ScreenHome(
    appState: ApplicationState
) = UIWrapper<HomeViewModel>(
    appState = appState
) {
    val state by uiState.collectAsState(initial = HomeState())
    val dataState by uiDataState.collectAsState(initial = HomeDataState())



    with(appState) {
        hideTopAppBar()
        setupBottomSheet {

        }
        bottomNavigationListener(object : BottomNavigationListener {
            override fun onRefresh(item: DashboardBottomNavigationMenu) {
                // remove empty

            }

            override fun onNavigate(item: DashboardBottomNavigationMenu) {
                navigateSingleTop(item.route)
            }

            override fun onFab() {
                showBottomSheet()
            }

        })
    }
    LazyColumn(
        content = {

        }
    )

}


@Preview
@Composable
fun PreviewScreenHome() {
    BaseMainApp(
        bottomBar = {
            DashboardBottomNavigation(currentRoute = Home.routeName)
        }
    ) {
        ScreenHome(rememberApplicationState())
    }

}