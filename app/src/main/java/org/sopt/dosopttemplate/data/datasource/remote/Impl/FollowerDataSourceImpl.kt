package org.sopt.dosopttemplate.data.datasource.remote.Impl

import org.sopt.dosopttemplate.data.datasource.remote.FollowerDataSource
import org.sopt.dosopttemplate.data.entity.FollowerList
import org.sopt.dosopttemplate.data.service.FollowerService
import javax.inject.Inject

class FollowerDataSourceImpl @Inject constructor(
    private val followerService: FollowerService
): FollowerDataSource {

    override suspend fun getFollowerList(): FollowerList =
        FollowerList(
            followerService.getFollowerList().data.map { data ->
                FollowerList.FollowerListData(
                    data.id,
                    data.email,
                    data.firstName,
                    data.lastName,
                    data.avatar
                )
            }
        )
}