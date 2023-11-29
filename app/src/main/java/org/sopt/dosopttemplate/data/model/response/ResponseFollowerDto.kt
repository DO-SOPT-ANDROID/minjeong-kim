package org.sopt.dosopttemplate.data.model.response

import kotlinx.serialization.SerialName
import org.sopt.dosopttemplate.data.entity.FollowerList

@Serializable
data class ResponseFollowerDto(
    @SerialName("page")
    val page: Int,
    @SerialName("per_page")
    val per_page: Int,
    @SerialName("total")
    val total: Int,
    @SerialName("total_pages")
    val total_pages: Int,
    @SerialName("data")
    val data: List<Data>,
    @SerialName("support")
    val support: Support,
) {
    @Serializable
    data class Data(
        @SerialName("id")
        val id: Int,
        @SerialName("email")
        val email: String,
        @SerialName("first_name")
        val firstName: String,
        @SerialName("last_name")
        val lastName: String,
        @SerialName("avatar")
        val avatar: String
    )

    @Serializable
    data class Support(
        @SerialName("url")
        val url: String,
        @SerialName("text")
        val text: String
    )

    fun getFollowerData() = data.map { data ->
        FollowerList.FollowerListData(
            id = data.id,
            email = data.email,
            first_name = data.firstName,
            last_name = data.lastName,
            avatar = data.avatar
        )
    }
}