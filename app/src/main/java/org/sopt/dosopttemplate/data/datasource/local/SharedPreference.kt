package org.sopt.dosopttemplate.data.datasource.local

import android.content.Context
import android.content.SharedPreferences
import org.sopt.dosopttemplate.data.entity.UserData


object SharedPreference {
    private lateinit var prefs: SharedPreferences

    fun initSetSharedPreference(context: Context) {
        prefs = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
    }

    fun isValidUserData() = prefs.getString(USER_ID, "")?.isNotBlank() ?: false

    fun setUserData(user: UserData) {
        with(prefs.edit()) {
            putString(USER_ID, user.id)
            putString(USER_PW, user.pw)
            putString(USER_NICKNAME, user.nickName)
            putString(USER_MBTI, user.mbti)
        }.commit()
    }

    fun getUserData(): UserData {
        with(prefs) {
            return UserData(
                getString(USER_ID, "").toString(),
                getString(USER_PW, "").toString(),
                getString(USER_NICKNAME, "").toString(),
                getString(USER_MBTI, "").toString()
            )
        }
    }

    fun clearUserData() {
        with(prefs.edit()) {
            clear()
            commit()
        }
    }

}

const val USER_PREFS = "user_prefs"
const val USER_ID = "user_id"
const val USER_PW = "user_pw"
const val USER_NICKNAME = "user_nickname"
const val USER_MBTI = "user_mbti"
