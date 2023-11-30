package org.sopt.dosopttemplate.data.datasource.remote

import org.sopt.dosopttemplate.data.entity.FollowerList

interface FollowerDataSource {

    suspend fun getFollowerList(): FollowerList
}