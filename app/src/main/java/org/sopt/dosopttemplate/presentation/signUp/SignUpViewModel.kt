package org.sopt.dosopttemplate.presentation.signUp

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.repository.AuthRepository
import org.sopt.dosopttemplate.util.UiState
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

    private val _signUpEnabled: MutableStateFlow<UiState<Boolean>> =
        MutableStateFlow(UiState.Loading)
    val signUpEnabled: StateFlow<UiState<Boolean>>
        get() = _signUpEnabled

    val checkBtnEnabled = MediatorLiveData<Boolean>().apply {
        addSource(username) { value = isSignUpValid() }
        addSource(nickname) { value = isSignUpValid() }
        addSource(password) { value = isSignUpValid() }
        addSource(mbti) { value = isSignUpValid() }
    }

    fun isSignUpValid(): Boolean {
        return isUserNameValid()
                && isPassWordValid()
                && !nickname.value.isNullOrBlank()
                && !mbti.value.isNullOrBlank()
    }

    fun isUserNameValid(): Boolean {
        val usernameMatcher = USERNAME_PATTERN.matcher(username.value.orEmpty())
        return username.value.isNullOrBlank() || usernameMatcher.find()
    }

    fun isPassWordValid(): Boolean {
        val passwordMatcher = PASSWORD_PATTERN.matcher(password.value.orEmpty())
        return password.value.isNullOrBlank() || passwordMatcher.find()
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
                _signUpEnabled.value = UiState.Success(true)
                Log.d("signUp viewModel: ", "${_signUpEnabled.value}")
            }.onFailure {
                _signUpEnabled.value = UiState.Failure(it.message.toString())
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