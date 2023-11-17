package org.sopt.dosopttemplate.presentation.logIn

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.data.entity.UserData
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding
import org.sopt.dosopttemplate.presentation.home.home.HomeActivity
import org.sopt.dosopttemplate.presentation.signUp.SignUpActivity
import org.sopt.dosopttemplate.util.SnackBar.makeSnackBar
import org.sopt.dosopttemplate.util.Toast.makeToast

@AndroidEntryPoint
class LogInActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var userData: UserData = UserData()

    private val viewModel by viewModels<LogInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

//        initSignUpActivityLauncher()
        initSignUpBtnClickListener()
        initLogInBtnClickListener()
        initObserveLogInEnabled()
//        initSetAutoLogIn()
    }

//    private fun initSetAutoLogIn() {
//        with(SharedPreference) {
//            initSetSharedPreference(this@LogInActivity)
//            if (isValidUserData()) {
//                sendUserData(getUserData())
//            }
//        }
//    }

//    private fun initSignUpActivityLauncher() {
//        resultLauncher = registerForActivityResult(
//            ActivityResultContracts.StartActivityForResult()
//        ) { result ->
//            if (result.resultCode == RESULT_OK) {
//                userData = result.data?.getParcelable(USER_DATA, UserData::class.java)
//                    ?: return@registerForActivityResult
//                SharedPreference.setUserData(userData)
//            }
//        }
//    }

    private fun initSignUpBtnClickListener() {
        binding.btnLogInDoSignUp.setOnClickListener {
            val intentToSignUp = Intent(this, SignUpActivity::class.java)
            startActivity(intentToSignUp)
        }
    }

    private fun initLogInBtnClickListener() {
        binding.btnLogInDoLogIn.setOnClickListener {
            viewModel.doSignIn(
                viewModel.username.value.toString(),
                viewModel.password.value.toString()
            )
        }
    }

    private fun initObserveLogInEnabled() {
        viewModel.signInEnabled.observe(this) { response ->
            if (response) doLogIn()
            else makeSnackBar(binding.root, MESSAGE_LOGIN_FAIL)
        }
    }

    private fun doLogIn() {
        makeToast(applicationContext, viewModel.signInAuthData.value?.id.toString())
        val intentToMain = Intent(this, HomeActivity::class.java)
        startActivity(intentToMain)
    }

    companion object {
        const val USER_DATA = "USER_DATA"
        const val MESSAGE_LOGIN_SUCCESS = "로그인 성공"
        const val MESSAGE_LOGIN_FAIL = "로그인 실패"
    }
}