package org.sopt.dosopttemplate.data.datasource.remote.Impl

import org.sopt.dosopttemplate.data.datasource.remote.AuthDataSource
import org.sopt.dosopttemplate.data.model.request.RequestSignInDto
import org.sopt.dosopttemplate.data.model.request.RequestSignUpDto
import org.sopt.dosopttemplate.data.model.response.ResponseSignInDto
import org.sopt.dosopttemplate.data.service.AuthService
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authService: AuthService
): AuthDataSource {

    override suspend fun doSignUp(
        username: String,
        nickname: String,
        password: String
    ): Unit = authService.doSignUp(
            RequestSignUpDto(
                username,
                nickname,
                password
            )
        )


    override suspend fun doSignIn(
        username: String,
        password: String
    ): ResponseSignInDto = authService.doSignIn(
        RequestSignInDto(
            username,
            password
        )
    )
}