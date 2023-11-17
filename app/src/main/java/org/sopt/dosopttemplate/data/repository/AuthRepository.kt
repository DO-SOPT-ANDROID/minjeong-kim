package org.sopt.dosopttemplate.data.repository

import android.provider.ContactsContract.CommonDataKinds.Nickname

interface AuthRepository {

    suspend fun doSignUp(
        username: String,
        nickname: String,
        password: String
    ): Result<Unit>
}