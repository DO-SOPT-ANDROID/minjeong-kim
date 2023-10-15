package org.sopt.dosopttemplate.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    var id : String = "",
    var pw : String = "",
    var nickName : String = "",
    var mbti : String = ""
):Parcelable
