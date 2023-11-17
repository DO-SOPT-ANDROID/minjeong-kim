package org.sopt.dosopttemplate.data.repository

import android.provider.ContactsContract.CommonDataKinds.Nickname

interface AuthRepository {

    suspend fun doLogIn(
        username: String,
        nickname: String,
        password: String
    ): Result<Unit>
}