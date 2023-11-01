package org.sopt.dosopttemplate.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    var id : String = "",
    var pw : String = "",
    var nickName : String = "",
    var mbti : String = ""
):Parcelable
