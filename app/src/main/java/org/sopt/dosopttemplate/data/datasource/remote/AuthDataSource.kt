package org.sopt.dosopttemplate.data.datasource.remote

interface AuthDataSource {

    suspend fun doSignUp(
        username: String,
        nickname: String,
        password: String
    ): Unit
}