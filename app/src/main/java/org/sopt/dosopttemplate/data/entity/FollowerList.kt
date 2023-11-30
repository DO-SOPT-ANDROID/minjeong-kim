package org.sopt.dosopttemplate.data.entity

data class FollowerList (
    val data: List<FollowerListData>
) {
    data class FollowerListData (
        val id: Int = 0,
        val email: String = "",
        val first_name: String = "",
        val last_name: String = "",
        val avatar: String = ""
    )
}