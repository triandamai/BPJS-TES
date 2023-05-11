/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.dashboard.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
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
import com.bluehabit.bpjs.android.components.HeaderSectionDashboardHome
import com.bluehabit.bpjs.android.components.ItemProgram
import com.bluehabit.bpjs.android.components.ItemService
import com.bluehabit.bpjs.android.components.button.ButtonClickToAction
import com.bluehabit.bpjs.android.featureCompose.programInformation.ProgramInformation
import com.bluehabit.bpjs.android.rememberApplicationState
import com.bluehabit.bpjs.android.ui.Grey100

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
        setupTopAppBar {
            HomeTopAppBar()
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
        modifier = Modifier
            .fillMaxSize()
            .background(
                Grey100
            ),
        content = {
            item {
                HeaderSectionDashboardHome(
                    title = "Program Layanan"
                )
            }
            items(dataState.programs) {
                ItemProgram(
                    margin = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 9.dp
                    ),
                    title = it.title,
                    subtitle = if (it.available) "Anda sudah terdaftar di layanan ini" else "",
                    available = it.available,
                    image = it.icon
                )
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
                ButtonClickToAction()
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.surface)
                ) {
                    HeaderSectionDashboardHome(
                        title = "Layanan Lainnya"
                    )
                }
            }
            gridItems(dataState.services, columnCount = 4){
                ItemService(
                    name = it.serviceName,
                    icon = it.serviceIcon,
                    onClick = {
                        navigateSingleTop(ProgramInformation.routeName)
                    }
                )
            }
        }
    )

}

@Composable
fun HomeTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(
                horizontal = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_jmo),
            contentDescription = ""
        )
        Row {
            Row {
                Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "")
                Text(text = "e-Wallet")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "")
        }
    }
}

@Preview
@Composable
fun PreviewScreenHome() {
    BaseMainApp(
        bottomBar = {
            DashboardBottomNavigation(currentRoute = Home.routeName)
        },
        topAppBar = {
            HomeTopAppBar()
        }
    ) {
        ScreenHome(rememberApplicationState())
    }

}