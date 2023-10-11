package org.sopt.dosopttemplate.presentation.main

import android.os.Bundle
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.data.UserData
import org.sopt.dosopttemplate.databinding.ActivityMainBinding
import org.sopt.dosopttemplate.presentation.logIn.LogInActivity
import org.sopt.dosopttemplate.util.getParcelable

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initMakeMainView()
    }

    private fun initMakeMainView() {
        val userData = intent.getParcelable(LogInActivity.USER_DATA, UserData::class.java)
        with (binding) {
            tvMainNickName.text = userData?.nickName ?: ""
            tvMainID.text = userData?.id ?: ""
            tvMainMBTI.text = userData?.mbti ?: ""
        }
    }
}