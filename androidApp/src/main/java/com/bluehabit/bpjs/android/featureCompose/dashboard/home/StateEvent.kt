/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureCompose.dashboard.home

import android.os.Parcelable
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.data.model.article.ArticleModel
import com.bluehabit.bpjs.data.model.transaction.TransactionModel
import com.bluehabit.bpjs.data.model.tutorial.TutorialBudgetModel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class HomeState(
    val showBalance: Boolean = true
) : Parcelable

@Immutable
@Parcelize
data class HomeDataState(
    val displayName: String = "Mario Jr.",
    val currentMonth: String = "April",
    val remainingBalance: BigDecimal = BigDecimal(20_000_000),
    val expenses: BigDecimal = BigDecimal(30_000_000),
    val income: BigDecimal = BigDecimal(100_000_000),
    //budget
    val remainingBudget: BigDecimal = BigDecimal(2_000_000),
    val usedAmount: BigDecimal = BigDecimal(3_000_000),
    val totalBudget: BigDecimal = BigDecimal(4_000_000),
    val score: Int = 50,
    val transactions: @RawValue List<TransactionModel> = listOf(
        TransactionModel(
            transactionName = "McDonald",
            isTransactionExpenses = false,
            transactionAmount = BigDecimal(90_000),
            transactionDate = LocalDate.now(),
            transactionAccountName = "Bank BCA",
            transactionCategory = "Makanan"
        ),
        TransactionModel(
            transactionName = "Listrik",
            isTransactionExpenses = true,
            transactionAmount = BigDecimal(100_000),
            transactionDate = LocalDate.now(),
            transactionAccountName = "Bank Jago",
            transactionCategory = "Utilitas"
        ),
        TransactionModel(
            transactionName = "KFC",
            isTransactionExpenses = false,
            transactionAmount = BigDecimal(10_000),
            transactionDate = LocalDate.now(),
            transactionAccountName = "Bank Jago",
            transactionCategory = "Makanan"
        )
    ),
    val tutorial: @RawValue List<TutorialBudgetModel> = listOf(
        TutorialBudgetModel(
            title = "Cara Transaksi di Budgetku",
            image = R.drawable.ic_dummy_tutorial
        ),
        TutorialBudgetModel(
            title = "Cara Atur Anggran",
            image = R.drawable.ic_dummy_tutorial_2
        ),
        TutorialBudgetModel(
            title = "Cara Buat Tujuan",
            image = R.drawable.ic_dummy_tutorial_3
        )
    ),
    val articles: @RawValue List<ArticleModel> = listOf(
        ArticleModel(
            title = "Pusat Bantuan",
            body = "Punya kendala atau pertanyyan terkait Budgetku? kamu bisa kirim di sini",
            image = R.drawable.ic_dummy_article,
            date = LocalDateTime.now(),
            likes = 200
        ),
        ArticleModel(
            title = "Cerdas Finansial",
            body = "Yuk melek finansial bersama Budgetku. Tersedia course keuangan untukmu",
            image = R.drawable.ic_dummy_article_2,
            date = LocalDateTime.now(),
            likes = 200
        ),
        ArticleModel(
            title = "Promo & Hadiah",
            body = "Yuk cek berbagai promo menarik di aplikasi Budgetku Sekarang!",
            image = R.drawable.ic_dummy_article_3,
            date = LocalDateTime.now(),
            likes = 200
        ),
        ArticleModel(
            title = "Tips Keuangan",
            body = "Bingung ngatur budget? disini kamu bisa tahu tips ngatur keuangan",
            image = R.drawable.ic_dummy_article_4,
            date = LocalDateTime.now(),
            likes = 200
        )
    )
) : Parcelable

sealed class HomeEvent {
    class SetName(var name: String) : HomeEvent()
}