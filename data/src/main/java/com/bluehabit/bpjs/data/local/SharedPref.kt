/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.local

import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPref(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        const val isLoggedInKey = "hsdracvjkd"
        const val tokenKey = "syrtfjykvsujgdf"
        const val languageKey = "dtfvdff"
    }

    fun setLanguage(lang: String) = sharedPreferences.edit {
        putString(languageKey, lang)
        apply()
    }

    fun getLanguage() = sharedPreferences.getString(languageKey, "").orEmpty()

    fun setIsLoggedIn(isLoggedIn: Boolean) = sharedPreferences.edit {
        putBoolean(isLoggedInKey, isLoggedIn)
        apply()
    }

    fun getIsLoggedIn(): Boolean =
        sharedPreferences.getBoolean(isLoggedInKey, false)

    fun setToken(token: String) = sharedPreferences.edit {
        putString(tokenKey, token)
        apply()
    }

    fun getToken(): String =
        sharedPreferences.getString(tokenKey, "")
            .orEmpty()

    fun setFirstRun() = sharedPreferences.edit {
        putBoolean("firstRun", false)
        apply()
    }

    fun getFirstRun(): Boolean {
        return sharedPreferences.getBoolean("firstRun", true)
    }

    fun setUserLoggedIn(
        token: String
    ) = sharedPreferences.edit {
        putBoolean(isLoggedInKey, true)
        putString(tokenKey, token)
        apply()
    }
}