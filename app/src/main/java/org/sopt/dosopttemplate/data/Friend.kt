package org.sopt.dosopttemplate.data

import androidx.annotation.DrawableRes

data class Friend(
    @DrawableRes val profile_img: Int,
    val name: String,
    val profile_message: String
)
