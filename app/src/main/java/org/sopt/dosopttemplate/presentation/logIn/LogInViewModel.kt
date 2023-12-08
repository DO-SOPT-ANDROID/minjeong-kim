package org.sopt.dosopttemplate.presentation.logIn

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.entity.AuthData
import org.sopt.dosopttemplate.data.repository.AuthRepository
import org.sopt.dosopttemplate.util.UiState
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val username: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    private val _signInAuthData: MutableStateFlow<UiState<AuthData>> =
        MutableStateFlow(UiState.Loading)
    val signInAuthData: StateFlow<UiState<AuthData>>
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
                _signInAuthData.value = UiState.Success(data)
                _signInEnabled.value = true
            }.onFailure {
                Log.d("signIn viewModel: ", "실패")
                _signInAuthData.value = UiState.Failure(it.message.toString())
                _signInEnabled.value = false
            }
        }
    }
}