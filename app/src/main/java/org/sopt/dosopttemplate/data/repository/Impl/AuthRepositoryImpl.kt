package org.sopt.dosopttemplate.data.repository.Impl

import android.util.Log
import org.sopt.dosopttemplate.data.datasource.remote.AuthDataSource
import org.sopt.dosopttemplate.data.entity.AuthData
import org.sopt.dosopttemplate.data.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
): AuthRepository {

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
    }.onSuccess {
        Log.d("auth repository: ", "성공")
    }.onFailure {
        Log.d("auth repository: ", "실패")
    }

    override suspend fun doSignIn(
        username: String,
        password: String
    ): Result<AuthData> = runCatching {
        authDataSource.doSignIn(
            username,
            password
        )
    }.map { data ->
        AuthData(data.id.toString(), data.username, data.nickname)
    }.onSuccess {
        Log.d("auth repository: ", "성공")
    }.onFailure {
        Log.d("auth repository: ", "실패")
    }
}