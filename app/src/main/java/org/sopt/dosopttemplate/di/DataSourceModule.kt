package org.sopt.dosopttemplate.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.dosopttemplate.data.datasource.remote.AuthDataSource
import org.sopt.dosopttemplate.data.datasource.remote.FollowerDataSource
import org.sopt.dosopttemplate.data.datasource.remote.Impl.AuthDataSourceImpl
import org.sopt.dosopttemplate.data.datasource.remote.Impl.FollowerDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun providesReqresDataSource(dataSourceImpl: FollowerDataSourceImpl): FollowerDataSource

    @Singleton
    @Binds
    abstract fun provideAuthDataSource(dataSourceImpl: AuthDataSourceImpl): AuthDataSource
}