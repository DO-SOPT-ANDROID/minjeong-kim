package org.sopt.dosopttemplate.data.service

import org.sopt.dosopttemplate.data.model.request.RequestSignInDto
import org.sopt.dosopttemplate.data.model.request.RequestSignUpDto
import org.sopt.dosopttemplate.data.model.response.ResponseSignInDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/v1/members")
    suspend fun doSignUp(
        @Body requestSignUp: RequestSignUpDto
    )

    @POST("api/v1/members/sign-in")
    suspend fun doSignIn(
        @Body requestSignIn: RequestSignInDto
    ): ResponseSignInDto
}