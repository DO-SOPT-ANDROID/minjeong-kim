package org.sopt.dosopttemplate.presentation.signUp

import android.content.Intent
import android.os.Bundle
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.data.UserData
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.presentation.logIn.LogInActivity
import org.sopt.dosopttemplate.presentation.logIn.LogInActivity.Companion.USER_DATA
import org.sopt.dosopttemplate.util.SnackBar.makeSnackBar
import org.sopt.dosopttemplate.util.Toast.makeToast

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
        makeToast(applicationContext, MESSAGE_SIGNUP_SUCCESS)
        sendSignUpData()
    }

    private fun sendSignUpData() {
        val intent: Intent = Intent(this, LogInActivity::class.java)
        with (binding) {
            intent.putExtra(
                USER_DATA,
                UserData(
                    etSignUpID.text.toString(),
                    etSignUpPW.text.toString(),
                    etSignUpNickName.text.toString(),
                    etSignUpMBTI.text.toString()
                ))
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    companion object {
        const val MESSAGE_SIGNUP_SUCCESS = "회원가입 성공"
        const val MESSAGE_SIGNUP_FAIL = "회원가입 실패: 모든 정보를 기입해야 합니다"
    }
}