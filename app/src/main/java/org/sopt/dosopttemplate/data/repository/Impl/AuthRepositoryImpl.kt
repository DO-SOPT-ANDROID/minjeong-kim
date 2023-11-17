package org.sopt.dosopttemplate.data.repository.Impl

import android.util.Log
import org.sopt.dosopttemplate.data.datasource.remote.AuthDataSource
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
        Log.d("viewModel username4: ", username)
        Log.d("viewModel nickname4: ", nickname)
        Log.d("viewModel password4: ", password)
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
}