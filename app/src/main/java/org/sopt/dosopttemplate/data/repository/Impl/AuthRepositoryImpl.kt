package org.sopt.dosopttemplate.data.repository.Impl

import android.util.Log
import org.sopt.dosopttemplate.data.datasource.remote.AuthDataSource
import org.sopt.dosopttemplate.data.entity.AuthData
import org.sopt.dosopttemplate.data.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {

    override suspend fun doSignUp(
        username: String,
        nickname: String,
        password: String
    ): Result<Unit> = runCatching {
        authDataSource.doSignUp(
            username,
            nickname,
            password
        )
    }.fold(
        onSuccess = {
            Log.d(AUTH_TAG, MSG_SUCCESS)
            Result.success(Unit)
        },
        onFailure = {
            Log.d(AUTH_TAG, MSG_FAILURE)
            Result.failure(it)
        }
    )

    override suspend fun doSignIn(
        username: String,
        password: String
    ): Result<AuthData> = runCatching {
        authDataSource.doSignIn(
            username,
            password
        ).getAuthData()
    }

    companion object {
        const val AUTH_TAG = "auth repository: "
        const val MSG_SUCCESS = "성공"
        const val MSG_FAILURE = "실패"
    }

}