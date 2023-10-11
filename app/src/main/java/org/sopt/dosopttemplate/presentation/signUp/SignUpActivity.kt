package org.sopt.dosopttemplate.presentation.signUp

import android.os.Bundle
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.util.SnackBar.makeSnackBar

class SignUpActivity : BaseActivity<ActivitySignupBinding>(R.layout.activity_signup) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSignUpBtnClickListener()
    }

    private fun initSignUpBtnClickListener() {
        binding.btSignUpDoSignUp.setOnClickListener {
            if (checkValidSignUp()) doSignUp()
            else makeSnackBar(binding.root, MESSAGE_SIGNUP_FAIL)
        }
    }

    private fun checkValidSignUp(): Boolean {
        with (binding) {
            return ((etSignUpID.length() in 6..10)
                && (etSignUpPW.length() in 8..12)
                && (etSignUpNickName.text.isNotBlank())
                && (etSignUpMBTI.text.isNotBlank()))
        }
    }

    private fun doSignUp() {
        makeSnackBar(binding.root, MESSAGE_SIGNUP_SUCCESS)
    }

    companion object {
        const val MESSAGE_SIGNUP_SUCCESS = "회원가입 성공"
        const val MESSAGE_SIGNUP_FAIL = "회원가입 실패: 모든 정보를 기입해야 합니다"
    }
}