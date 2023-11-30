package org.sopt.dosopttemplate.presentation.signUp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.repository.AuthRepository
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

    fun isSignUpValid(): Boolean {
        return isUserNameValid()
                && isPassWordValid()
                && !nickname.value.isNullOrBlank()
                && !mbti.value.isNullOrBlank()
    }

    private fun isUserNameValid(): Boolean =
        username.value?.length in 6..10 && !username.value.isNullOrBlank()

    private fun isPassWordValid(): Boolean =
        password.value?.length in 8..12 && !password.value.isNullOrBlank()

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
}