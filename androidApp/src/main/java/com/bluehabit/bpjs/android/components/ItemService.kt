/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.base.BaseMainApp
import com.bluehabit.bpjs.android.ui.Grey200
import com.bluehabit.bpjs.android.ui.Grey600

@Composable
fun ItemService(
    icon: Int = R.drawable.ic_dummy_saving,
    name: String = "Info Program",
    onClick: () -> Unit = {}
) {
    val ctx = LocalContext.current
    val currentWidth = ctx
        .resources
        .displayMetrics.widthPixels.dp /
            LocalDensity.current.density


    val buttonSize = currentWidth / 5

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .width(
                buttonSize
            )
            .height(buttonSize + 40.dp)
            .clickable(
                enabled = true,
                onClick = onClick
            )
            .padding(
                horizontal = 6.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        10.dp
                    )
                )
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(
                        10.dp
                    ),
                    color = Grey600
                )
                .padding(
                    all = 10.dp
                )
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Preview
@Composable
fun PreviewItemService() {
    BaseMainApp {
        ItemService()
    }
}