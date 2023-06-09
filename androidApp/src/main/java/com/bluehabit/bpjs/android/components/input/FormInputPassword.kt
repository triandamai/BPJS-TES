/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.components.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.base.BaseMainApp

@Composable
fun FormInputPassword(
    value: String = "",
    label: String = "",
    placeholder: String = "",
    error: Boolean = false,
    errorMessage: String = "",
    keyboardActions: KeyboardActions = KeyboardActions(),
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    onChange: (String) -> Unit = {}
) {
    var visible by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onChange,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(),
            placeholder = {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Normal
                )
            },
            label={
                Text(
                    text = label,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Normal
                )
            },
            isError = error,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = if (visible) R.drawable.eye_open else R.drawable.eye_close),
                    contentDescription = "",
                    tint = if (visible) MaterialTheme.colors.primary
                    else MaterialTheme.colors.onSurface,
                    modifier = Modifier.clickable {
                        visible = !visible
                    }
                )
            },
            textStyle = MaterialTheme.typography.subtitle2,
            visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation()
        )

        Text(
            text = errorMessage,
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Normal,
            color = if (error) MaterialTheme.colors.error else Color.Transparent
        )
        Spacer(modifier = Modifier.height(8.dp))

    }
}

@Preview
@Composable
fun PreviewFormInputPassword() {
    BaseMainApp {
        FormInputPassword()
    }
}