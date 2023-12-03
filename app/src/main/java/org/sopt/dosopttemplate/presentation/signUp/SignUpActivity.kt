package org.sopt.dosopttemplate.presentation.signUp

import android.content.Intent
import android.os.Bundle
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

        initSetSignUpErrorCondition()
        initSignUpBtnClickListener()
        initObserveSignUpEnabled()
    }

    private fun initSetSignUpErrorCondition() {
        checkUserNameValid()
        checkPassWordValid()
    }

    private fun checkUserNameValid() {
        viewModel.username.observe(this) {
            if (!viewModel.isUserNameValid()) {
                binding.layoutSignUpID.error = MESSAGE_USERNAME_CONDITION
            } else {
                binding.layoutSignUpID.error = null
            }
        }
    }

    private fun checkPassWordValid() {
        viewModel.password.observe(this) {
            if (!viewModel.isPassWordValid()) {
                binding.layoutSignUpPW.error = MESSAGE_PASSWORD_CONDITION
            } else {
                binding.layoutSignUpPW.error = null
            }
        }
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

        const val MESSAGE_USERNAME_CONDITION = "영문, 숫자 포함 6-10글자"
        const val MESSAGE_PASSWORD_CONDITION = "영문, 숫자, 특수문자 포함 6-12글자"
    }
}