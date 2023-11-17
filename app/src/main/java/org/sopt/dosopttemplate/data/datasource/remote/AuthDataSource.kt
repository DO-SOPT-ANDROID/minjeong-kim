package org.sopt.dosopttemplate.data.datasource.remote

import org.sopt.dosopttemplate.data.model.response.ResponseSignInDto

interface AuthDataSource {

    suspend fun doSignUp(
        username: String,
        nickname: String,
        password: String
    ): Unit

    suspend fun doSignIn(
        username: String,
        password: String
    ): ResponseSignInDto
}