package org.sopt.dosopttemplate.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.dosopttemplate.data.repository.AuthRepository
import org.sopt.dosopttemplate.data.repository.FollowerRepository
import org.sopt.dosopttemplate.data.repository.Impl.AuthRepositoryImpl
import org.sopt.dosopttemplate.data.repository.Impl.FollowerRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesReqresRepository(repoImpl: FollowerRepositoryImpl): FollowerRepository

    @Singleton
    @Binds
    abstract fun provideAuthRepository(repoImpl: AuthRepositoryImpl): AuthRepository
}