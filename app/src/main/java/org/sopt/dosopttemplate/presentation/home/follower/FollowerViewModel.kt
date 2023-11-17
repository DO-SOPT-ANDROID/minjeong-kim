package org.sopt.dosopttemplate.presentation.home.follower

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.entity.FollowerList
import org.sopt.dosopttemplate.data.repository.FollowerRepository
import javax.inject.Inject

@HiltViewModel
class FollowerViewModel @Inject constructor(
    private val repository: FollowerRepository
) : ViewModel() {

    private val _followerList = MutableLiveData<List<FollowerList.FollowerListData>>()
    val followerList: LiveData<List<FollowerList.FollowerListData>>
        get() = _followerList

    fun getFollowerList() {
        viewModelScope.launch {
            repository.getFollowerList().onSuccess { response ->
                Log.d("follower viewModel: ", "연결 성공")
                _followerList.value = response.data.toList()
            }.onFailure {
                Log.d("follower viewModel: ", "연결 실패")
            }
        }
    }
}