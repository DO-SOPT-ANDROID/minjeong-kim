package org.sopt.dosopttemplate.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.dosopttemplate.data.service.AuthService
import org.sopt.dosopttemplate.data.service.FollowerService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideFollowerService(@ReqresRetrofit retrofit: Retrofit): FollowerService =
        retrofit.create(FollowerService::class.java)

    @Provides
    @Singleton
    fun provideAuthService(@AuthRetrofit retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)
}