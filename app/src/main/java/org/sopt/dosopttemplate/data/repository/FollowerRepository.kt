package org.sopt.dosopttemplate.data.repository

import org.sopt.dosopttemplate.data.entity.FollowerList

interface FollowerRepository {

    suspend fun getFollowerList(): Result<FollowerList>
}