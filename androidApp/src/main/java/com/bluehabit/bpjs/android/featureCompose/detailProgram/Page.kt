/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.detailProgram

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bluehabit.bpjs.android.ApplicationState
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.base.BaseMainApp
import com.bluehabit.bpjs.android.base.UIWrapper
import com.bluehabit.bpjs.android.components.HeaderDetailProgram
import com.bluehabit.bpjs.android.components.ItemDetail
import com.bluehabit.bpjs.android.ui.Grey100
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

object DetailProgram {
    const val routeName = "DetailProgram"
    const val argKey = "id"
    fun routeName() = "$routeName/{$argKey}"

}

fun NavGraphBuilder.routeDetailProgram(
    state: ApplicationState,
) {
    composable(
        DetailProgram.routeName(),
        arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
            }
        )
    ) {
        ScreenDetailProgram(appState = state)
    }
}

@Composable
internal fun ScreenDetailProgram(
    appState: ApplicationState,
) = UIWrapper<DetailProgramViewModel>(appState = appState) {
    val dataState by uiDataState.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 0
    )

    with(appState) {
        setupTopAppBar {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            navigateUp()
                        }
                    )
                },
                title = {
                    Text(text = dataState.program?.title.orEmpty())
                }
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {
        Column(
            modifier = Modifier.padding(
                all = 16.dp
            ).background(Grey100)
        ) {
            HeaderDetailProgram(
                title = dataState.program?.title.orEmpty(),
                subtitle = if (dataState.program?.available == true) "Anda sudah terdaftar di layanan ini" else "Anda belum terdaftar",
                image = dataState.program?.icon ?: R.drawable.ic_dummy_saving
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.height(40.dp),
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.primary
        ) {
            Tab(
                selected = pagerState.currentPage == 0,
                onClick = {
                    runSuspend {
                        pagerState.scrollToPage(0)
                    }
                }
            ) {
                Text(text = "Manfaat")
            }
            Tab(
                selected = pagerState.currentPage == 1,
                onClick = {
                    runSuspend {
                        pagerState.scrollToPage(1)
                    }
                }
            ) {
                Text(text = "Besar Iuran")
            }
        }
        HorizontalPager(
            count = 2,
            state = pagerState,
            userScrollEnabled = true,
            modifier = Modifier.background(MaterialTheme.colors.surface)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(
                    horizontal = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(
                    8.dp
                ),
                content = {
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    if (it == 0) {
                        items(dataState.program?.benefit.orEmpty()) {
                            ItemDetail(
                                content = it
                            )
                        }
                    }
                    if (it == 1) {
                        items(dataState.program?.contribution.orEmpty()) {
                            ItemDetail(
                                content = it
                            )
                        }
                    }
                })
        }
    }
}

@Preview
@Composable
fun PreviewScreenDetailProgram() {
    BaseMainApp {
        ScreenDetailProgram(it)
    }
}