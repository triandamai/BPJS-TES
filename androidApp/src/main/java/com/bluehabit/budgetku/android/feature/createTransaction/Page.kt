/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.android.feature.createTransaction

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bluehabit.budgetku.android.ApplicationState
import com.bluehabit.budgetku.android.R
import com.bluehabit.budgetku.android.base.BaseMainApp
import com.bluehabit.budgetku.android.base.UIWrapper
import com.bluehabit.budgetku.android.components.bottomSheet.BottomSheetDatePicker
import com.bluehabit.budgetku.android.components.HeaderStepWithProgress
import com.bluehabit.budgetku.android.components.ScreenInputFeedback
import com.bluehabit.budgetku.android.components.ScreenInputSuccess
import com.bluehabit.budgetku.android.feature.createTransaction.CreateTransactionBottomSheetType.DATE_PICKER
import com.bluehabit.budgetku.android.feature.createTransaction.CreateTransactionBottomSheetType.CATEGORY
import com.bluehabit.budgetku.android.feature.createTransaction.components.ScreenInputAccount
import com.bluehabit.budgetku.android.feature.createTransaction.components.ScreenInputAmount
import com.bluehabit.budgetku.android.feature.createTransaction.components.ScreenInputDateTransaction
import com.bluehabit.budgetku.android.feature.createTransaction.components.ScreenInputTransactionNameAndCategory
import com.bluehabit.budgetku.android.feature.createTransaction.components.ScreenInputTransactionType
import com.bluehabit.budgetku.android.ui.Blue800

object CreateTransaction {
    const val routeName = "CreateTransaction"
}

fun NavGraphBuilder.routeCreateTransaction(
    state: ApplicationState,
) {
    composable(CreateTransaction.routeName) {
        ScreenCreateTransaction(appState = state)
    }
}

@Composable
internal fun ScreenCreateTransaction(
    appState: ApplicationState,
) = UIWrapper<CreateTransactionViewModel>(appState = appState) {
    val state by uiState.collectAsState()

    with(appState) {
        hideTopAppBar()

        setupBottomSheet {
            when (state.bottomSheetType) {
                CATEGORY -> {}
                DATE_PICKER -> {
                    BottomSheetDatePicker(
                        onSubmit = {
                            hideBottomSheet()
                        }
                    )
                }
            }

        }
    }
    BackHandler {
        if (state.step == 1) {
            //show confirmation
        } else {
            dispatch(CreateTransactionEvent.PrevPage)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue800)
    ) {
        when (state.step) {
            1 -> ScreenInputAmount(
                onClear = {},
                onRemove = {},
                onChange = {},
                onSubmit = {
                    dispatch(CreateTransactionEvent.NexPage)
                }
            )

            2 -> ScreenInputTransactionType(
                selected = "",
                onSelectedType = {
                    dispatch(CreateTransactionEvent.NexPage)
                }
            )

            3 -> ScreenInputAccount(
                transactionType = "",
                selectedAccount = "",
                onSelectedAccount = {
                    dispatch(CreateTransactionEvent.NexPage)
                }
            )

            4 -> ScreenInputTransactionNameAndCategory(
                transactionName = "",
                onChange = {},
                onSelectCategory = {
                    dispatch(CreateTransactionEvent.NexPage)
                },
            )

            5 -> ScreenInputDateTransaction(
                date = null,
                onSelectDate = {
                    dispatch(CreateTransactionEvent.ChangeBottomSheet(DATE_PICKER))
                    showBottomSheet()
                },
                onAddMore = {},
                onSave = {
                    dispatch(CreateTransactionEvent.NexPage)
                }
            )

            6 -> ScreenInputSuccess(
                title = stringResource(R.string.text_title_success_create_transaction),
                subtitle = stringResource(R.string.text_sub_title_like_create_transaction),
                onSubmit = {
                    dispatch(CreateTransactionEvent.NexPage)
                }
            )

            7 -> ScreenInputFeedback(
                title = stringResource(R.string.text_title_feedback_create_transaction),
                onSubmit = {

                }
            )

            else -> ScreenInputAmount()
        }

        if (state.step in 1..5) {
            HeaderStepWithProgress(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.TopCenter),
                iconColor = MaterialTheme.colors.onPrimary,
                backgroundColor = MaterialTheme.colors.onPrimary,
                color = MaterialTheme.colors.onPrimary,
                total = 5,
                progress = state.step,
                onBackPress = {
                    if (state.step > 1) {
                        dispatch(CreateTransactionEvent.PrevPage)
                    }
                },
                onClose = {

                }
            )
        }
    }

}

@Preview
@Composable
fun PreviewScreenCreateTransaction() {
    BaseMainApp {
        ScreenCreateTransaction(it)
    }
}