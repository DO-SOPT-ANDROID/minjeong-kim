package org.sopt.dosopttemplate.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.dosopttemplate.data.entity.AuthData

@Serializable
data class ResponseSignInDto (
    @SerialName("id")
    val id: Int,
    @SerialName("username")
    val username: String,
    @SerialName("nickname")
    val nickname: String
) {
    fun getAuthData() = AuthData(
        id = this.id.toString(),
        username = this.username,
        nickname = this.nickname
    )
}