/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.base.BaseMainApp
import com.bluehabit.bpjs.android.ui.Grey100

@Composable
fun HeaderDetailProgram(
    image: Int = R.drawable.ic_dummy_saving,
    title: String = "Jaminan Hari Tua",
    subtitle: String = "Anda sudah terdaftar di layanan ini"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                MaterialTheme.shapes.small
            )
            .background(MaterialTheme.colors.surface)
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 16.dp
                )
        ) {
            Row {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
            Icon(
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = "",
                modifier = Modifier.align(Alignment.TopEnd)
            )

        }
        Divider()
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Berupa uang tunai yang bearnya merupakan nilai akumulasi iuran ditambah hasil pengembangnya")
    }
}

@Preview
@Composable
fun PreviewHeaderDetailProgram() {
    BaseMainApp {
        Column(
            modifier = Modifier
                .background(Grey100)
                .padding(
                    horizontal = 16.dp
                )

        ) {
            HeaderDetailProgram()
        }
    }
}