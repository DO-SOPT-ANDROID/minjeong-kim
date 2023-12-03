package org.sopt.dosopttemplate.presentation.signUp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.repository.AuthRepository
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val username: MutableLiveData<String> = MutableLiveData()
    val nickname: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()
    val mbti: MutableLiveData<String> = MutableLiveData()

    private val _signUpEnabled = MutableLiveData<Boolean>()
    val signUpEnabled: LiveData<Boolean> = _signUpEnabled

    private val _isBtnEnabled = MutableLiveData<Boolean>()
    val isBtnEnabled: LiveData<Boolean>
        get() = _isBtnEnabled

    fun isSignUpValid(): Boolean {
        return isUserNameValid()
                && isPassWordValid()
                && !nickname.value.isNullOrBlank()
                && !mbti.value.isNullOrBlank()
    }

    fun isUserNameValid(): Boolean {
        val usernameMatcher = USERNAME_PATTERN.matcher(username.value)
        return usernameMatcher.find() && !username.value.isNullOrBlank()
    }

    fun isPassWordValid(): Boolean {
        val passwordMatcher = PASSWORD_PATTERN.matcher(password.value)
        return passwordMatcher.find() && !password.value.isNullOrBlank()
    }

    fun doSignUp(
        username: String,
        nickname: String,
        password: String
    ) {
        viewModelScope.launch {
            repository.doSignUp(
                username,
                nickname,
                password
            ).onSuccess { response ->
                _signUpEnabled.value = true
                Log.d("signUp viewModel: ", "${_signUpEnabled.value}")
            }.onFailure {
                _signUpEnabled.value = false
                Log.d("signUp viewModel: ", "실패")
            }
        }
    }

    companion object {
        const val USERNAME_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,10}\$"
        const val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^+\\-=]).{6,12}\$"
        val USERNAME_PATTERN: Pattern = Pattern.compile(USERNAME_REGEX)
        val PASSWORD_PATTERN: Pattern = Pattern.compile(PASSWORD_REGEX)
    }
}