/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bluehabit.bpjs.android.base.BaseMainApp

@Composable
fun ButtonClickToAction(
    margin: PaddingValues = PaddingValues(
        horizontal = 16.dp
    ),
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier.padding(margin)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        2.dp
                    )
                )
                .clickable(
                    enabled = true,
                    onClick = onClick
                )
                .background(
                    MaterialTheme.colors.primary.copy(
                        alpha = 0.3f
                    )
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "PROGRAM LAINNYA",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.primary
            )
            Icon(
                imageVector = Icons.Outlined.ArrowForward,
                contentDescription = "",
                tint = MaterialTheme.colors.primary
            )

        }
    }
}

@Preview
@Composable
fun PreviewButtonClickToAction() {
    BaseMainApp {
        ButtonClickToAction()
    }
}