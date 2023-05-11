/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.programInformation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bluehabit.bpjs.android.ApplicationState
import com.bluehabit.bpjs.android.base.BaseMainApp
import com.bluehabit.bpjs.android.base.UIWrapper
import com.bluehabit.bpjs.android.components.ItemProgramInformation
import com.bluehabit.bpjs.android.featureCompose.detailProgram.DetailProgram

object ProgramInformation {
    const val routeName = "ProgramInformation"
}

fun NavGraphBuilder.routeProgramInformation(
    state: ApplicationState,
) {
    composable(ProgramInformation.routeName) {
        ScreenProgramInformation(appState = state)
    }
}

@Composable
internal fun ScreenProgramInformation(
    appState: ApplicationState,
) = UIWrapper<ProgramInformationViewModel>(appState = appState) {
    val state by uiState.collectAsState()
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
                    Text(text = "Program BPJamsostek")
                }
            )

        }
    }
    LazyColumn(content = {
        items(state.program) {
            ItemProgramInformation(
                title = it.title,
                image = it.icon,
                onClick = {
                    navigateSingleTop(DetailProgram.routeName, it.id.toString())
                }
            )
        }
    })
}

@Preview
@Composable
fun PreviewScreenProgramInformation() {
    BaseMainApp {
        ScreenProgramInformation(it)
    }
}