/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bluehabit.bpjs.android.base.BaseMainApp

@Composable
fun ButtonSecondary(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.button,
    fullWidth: Boolean = true,
    height: Dp = 45.dp,
    onClick: () -> Unit = {}
) {
    val properties = if (fullWidth) modifier.fillMaxWidth() else modifier

    TextButton(
        enabled = enabled,
        onClick = onClick,
        modifier = properties
            .height(height),
        shape = RoundedCornerShape(
            size = 2.dp
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = MaterialTheme.colors.primary
        )
    ) {
        Text(
            text = text,
            style = textStyle,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun PreviewButtonSecondary() {
    BaseMainApp {
        ButtonSecondary(
            text = "Continue"
        )
    }
}