/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.data.common

import com.bluehabit.bpjs.data.model.BaseResponse
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> safeApiCall(call: () -> HttpResponse): Response<T> {
    return try {
        val response = call.invoke()
        if (response.status.value in 200..209) {
            val data = response.body<BaseResponse<T>>()
            Response.Result(data.data)
        } else {
            val data = response.body<BaseResponse<List<Any>>>()
            Response.Error(data.message, data.code)
        }
    }catch (e:Exception){
        Response.Error(e.message.orEmpty())
    }
}

suspend inline fun <reified T> safeApiCall(
    onSaveToken: (token: String) -> Unit = {},
    call: () -> HttpResponse
): Response<T> {
    return try {
        val response = call.invoke()
        if (response.status.value in 200..209) {
            val data = response.body<BaseResponse<T>>()
            if (data.token.isNotEmpty()) {
                onSaveToken(data.token)
            }
            Response.Result(data.data)
        } else {
            val data = response.body<BaseResponse<List<Any>>>()
            Response.Error(data.message, data.code)
        }
    } catch (e:Exception){
        Response.Error(e.message.orEmpty())
    }
}
