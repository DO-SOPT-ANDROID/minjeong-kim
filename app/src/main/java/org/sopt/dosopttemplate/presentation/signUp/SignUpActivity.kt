package org.sopt.dosopttemplate.presentation.signUp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.presentation.logIn.LogInActivity
import org.sopt.dosopttemplate.util.SnackBar.makeSnackBar

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignupBinding>(R.layout.activity_signup) {

    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        initSignUpBtnClickListener()
        initObserveSignUpEnabled()
    }

    private fun initSignUpBtnClickListener() {
        binding.btnSignUpDoSignUp.setOnClickListener {
            if (viewModel.isSignUpValid()) {
                viewModel.doSignUp(
                    viewModel.username.value.toString(),
                    viewModel.nickname.value.toString(),
                    viewModel.password.value.toString()
                )
            } else makeSnackBar(binding.root, MESSAGE_SIGNUP_FAIL)
        }
    }

    private fun initObserveSignUpEnabled() {
        viewModel.signUpEnabled.observe(this) { response ->
            if (response) doSignUp()
            else makeSnackBar(binding.root, MESSAGE_SIGNUP_FAIL)
        }
    }

    private fun doSignUp() {
        val intent = Intent(this, LogInActivity::class.java)
        setResult(RESULT_OK, intent)
        finish()
    }

    companion object {
        const val MESSAGE_SIGNUP_SUCCESS = "회원가입 성공"
        const val MESSAGE_SIGNUP_FAIL = "회원가입 실패: 모든 정보를 기입해야 합니다"
    }
}