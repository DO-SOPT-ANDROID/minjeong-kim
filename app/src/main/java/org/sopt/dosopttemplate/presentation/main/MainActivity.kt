package org.sopt.dosopttemplate.presentation.main

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.data.UserData
import org.sopt.dosopttemplate.databinding.ActivityMainBinding
import org.sopt.dosopttemplate.presentation.logIn.LogInActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initMakeMainView()
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun initMakeMainView() {
        val userData = intent.getParcelableExtra(LogInActivity.USER_DATA, UserData::class.java)
        with (binding) {
            tvMainNickName.text = userData?.nickName ?: ""
            tvMainID.text = userData?.id ?: ""
            tvMainMBTI.text = userData?.mbti ?: ""
        }
    }
}