package org.sopt.dosopttemplate.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthData (
    val id: String,
    val username: String,
    val nickname: String
): Parcelable