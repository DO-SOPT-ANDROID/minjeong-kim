package org.sopt.dosopttemplate.data.repository.Impl

import android.util.Log
import org.sopt.dosopttemplate.data.datasource.remote.FollowerDataSource
import org.sopt.dosopttemplate.data.entity.FollowerList
import org.sopt.dosopttemplate.data.repository.FollowerRepository
import javax.inject.Inject

class FollowerRepositoryImpl @Inject constructor(
    private val followerDataSource: FollowerDataSource
) : FollowerRepository {

    override suspend fun getFollowerList()
            : Result<FollowerList> = runCatching {
        followerDataSource.getFollowerList()
    }.fold(
        onSuccess = {
            Log.d(FOLLOWER_TAG, MSG_SUCCESS)
            Result.success(followerDataSource.getFollowerList())
        },
        onFailure = {
            Log.d(FOLLOWER_TAG, MSG_FAILURE)
            Result.failure(it)
        }
    )

    companion object {
        const val FOLLOWER_TAG = "follower repository: "
        const val MSG_SUCCESS = "성공"
        const val MSG_FAILURE = "실패"
    }
}