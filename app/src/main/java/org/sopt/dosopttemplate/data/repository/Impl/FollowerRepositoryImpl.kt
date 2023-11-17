package org.sopt.dosopttemplate.data.repository.Impl

import android.util.Log
import org.sopt.dosopttemplate.data.datasource.remote.FollowerDataSource
import org.sopt.dosopttemplate.data.entity.FollowerList
import org.sopt.dosopttemplate.data.repository.FollowerRepository
import javax.inject.Inject

class FollowerRepositoryImpl @Inject constructor(
    private val followerDataSource: FollowerDataSource
): FollowerRepository {

    override suspend fun getFollowerList(): Result<FollowerList> = runCatching {
        followerDataSource.getFollowerList()
    }.onSuccess {
        Log.d("follower repository: ", "성공")
    }.onFailure {
        Log.d("follower repository: ", "실패")
    }
}