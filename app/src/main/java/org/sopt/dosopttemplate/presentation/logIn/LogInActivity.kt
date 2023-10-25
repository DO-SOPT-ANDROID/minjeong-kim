package org.sopt.dosopttemplate.presentation.logIn

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.data.UserData
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding
import org.sopt.dosopttemplate.presentation.home.home.HomeActivity
import org.sopt.dosopttemplate.presentation.signUp.SignUpActivity
import org.sopt.dosopttemplate.util.SnackBar.makeSnackBar
import org.sopt.dosopttemplate.util.Toast.makeToast
import org.sopt.dosopttemplate.util.getParcelable

class LogInActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var userData: UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSignUpActivityLauncher()
        initSignUpBtnClickListener()
        initLogInBtnClickListener()
    }

    private fun initSignUpActivityLauncher() {
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                userData = result.data?.getParcelable(USER_DATA, UserData::class.java) ?: return@registerForActivityResult
            }
        }
    }

    private fun initSignUpBtnClickListener() {
        binding.btLogInDoSignUp.setOnClickListener {
            intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun initLogInBtnClickListener() {
        binding.btLogInDoLogIn.setOnClickListener {
            if (checkValidLogIn()) doLogIn()
            else makeSnackBar(binding.root, MESSAGE_LOGIN_FAIL)
        }
    }

    private fun checkValidLogIn(): Boolean {
        with(binding) {
            return (userData.id == etLogInId.text.toString() && userData.pw == etLogInPw.text.toString())
        }
    }

    private fun doLogIn() {
        makeToast(applicationContext, MESSAGE_LOGIN_SUCCESS)
        sendUserData()
    }

    private fun sendUserData() {
        intent = Intent(this, HomeActivity::class.java)
        with(binding) {
            intent.putExtra(
                USER_DATA,
                userData
            )
        }

        startActivity(intent)
    }

    companion object {
        const val USER_DATA = "USER_DATA"
        const val MESSAGE_LOGIN_SUCCESS = "로그인 성공"
        const val MESSAGE_LOGIN_FAIL = "로그인 실패"
    }
}