package org.sopt.dosopttemplate.di

import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.dosopttemplate.BuildConfig
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val AUTH_BASE_URL = BuildConfig.AUTH_BASE_URL
    private const val REQRES_BASE_URL = BuildConfig.REQRES_BASE_URL

    @Provides
    @Singleton
    @DoSoptRetrofit
    fun provideOkHttpClient(@DoSoptRetrofit interceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    @DoSoptRetrofit
    fun provideLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor { message ->
            Log.d("retrofit message", message)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Singleton
    @Provides
    @DoSoptRetrofit
    fun provideReqresRetrofit(@DoSoptRetrofit okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(REQRES_BASE_URL)
            .client(okHttpClient)
            .build()
}