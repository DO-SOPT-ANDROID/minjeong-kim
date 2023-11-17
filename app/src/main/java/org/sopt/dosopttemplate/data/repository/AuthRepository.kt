package org.sopt.dosopttemplate.data.repository

import android.provider.ContactsContract.CommonDataKinds.Nickname
import org.sopt.dosopttemplate.data.entity.AuthData

interface AuthRepository {

    suspend fun doSignUp(
        username: String,
        nickname: String,
        password: String
    ): Result<Unit>

    suspend fun doSignIn(
        username: String,
        password: String
    ): Result<AuthData>
}