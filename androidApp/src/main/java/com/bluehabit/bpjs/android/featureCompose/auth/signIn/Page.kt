/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.auth.signIn

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bluehabit.bpjs.android.ApplicationState
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.base.BaseMainApp
import com.bluehabit.bpjs.android.base.UIWrapper
import com.bluehabit.bpjs.android.base.contract.GoogleAuthContract
import com.bluehabit.bpjs.android.components.button.ButtonGoogle
import com.bluehabit.bpjs.android.components.button.ButtonPrimary
import com.bluehabit.bpjs.android.components.button.ButtonSecondary
import com.bluehabit.bpjs.android.components.input.FormInput
import com.bluehabit.bpjs.android.components.input.FormInputPassword
import com.bluehabit.bpjs.android.featureCompose.dashboard.home.Home
import com.bluehabit.bpjs.android.rememberApplicationState
import com.bluehabit.bpjs.android.ui.Blue800
import com.bluehabit.bpjs.android.ui.Grey500

object SignIn {
    const val routeName = "SignIn"
}

fun NavGraphBuilder.routeSignIn(
    state: ApplicationState,
) {
    composable(SignIn.routeName) {
        ScreenSignIn(state)
    }
}

@Composable
internal fun ScreenSignIn(appState: ApplicationState) = UIWrapper<SignInViewModel>(
    appState = appState
) {
    val state by uiState.collectAsState()


    Column(
        modifier = Modifier.padding(
            horizontal = 16.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_jmo),
            contentDescription = "",
            modifier = Modifier.size(
                70.dp
            )
        )
        Text(
            text = "Login",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Text(
            text = "Silahkan login untuk masuk aplikasi",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(20.dp))
        FormInput(
            placeholder = "Email Anda",
            label = "Email Anda",
            value = state.email,
            onChange = {
                commit {
                    copy(
                        email = it
                    )
                }
            }
        )
        FormInputPassword(
            placeholder = "Kata Sandi",
            label = "Kata Sandi",
            value = state.password,
            onChange = {
                commit {
                    copy(
                        password = it
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Lupa Akun?",
                style = MaterialTheme.typography.button,
                modifier = Modifier.clickable { }
            )
            Text(
                text = "Lupa Kata Sandi?",
                style = MaterialTheme.typography.button,
                modifier = Modifier.clickable { }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        ButtonPrimary(text = "Login") {
            hideKeyboard()
            dispatch(SignInEvent.SignInWithEmail)
        }
        Spacer(modifier = Modifier.height(16.dp))
        ButtonSecondary(text = "Buat Akun")
    }

}


@Preview
@Composable
fun PreviewScreenSignIn() {
    BaseMainApp {
        ScreenSignIn(
            appState = rememberApplicationState()
        )
    }
}

