package org.sopt.dosopttemplate.presentation.logIn

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.entity.AuthData
import org.sopt.dosopttemplate.data.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val username: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    private val _signInAuthData: MutableLiveData<AuthData> = MutableLiveData()
    val signInAuthData: LiveData<AuthData>
        get() = _signInAuthData

    private val _signInEnabled = MutableLiveData<Boolean>()
    val signInEnabled: LiveData<Boolean> = _signInEnabled

    fun doSignIn(
        username: String,
        password: String
    ) {
        viewModelScope.launch {
            repository.doSignIn(
                username,
                password
            ).onSuccess { data ->
                _signInAuthData.value = data
                _signInEnabled.value = true
            }.onFailure {
                Log.d("signIn viewModel: ", "실패")
                _signInEnabled.value = false
            }
        }
    }
}