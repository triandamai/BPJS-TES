package com.bluehabit.bpjs.android.featureCompose.splashScreen


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class SplashState(
    val a: String = ""
) : Parcelable

@Immutable
@Parcelize
data class SplashDataState(
    val a: String = ""
) : Parcelable

sealed interface SplashEvent {
    object CheckSession:SplashEvent
}