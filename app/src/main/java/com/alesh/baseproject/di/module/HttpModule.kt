package com.alesh.baseproject.di.module

import com.alesh.baseproject.common.constant.TIME_OUT
import com.alesh.data.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
object HttpModule {

    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                readTimeout(TIME_OUT, TimeUnit.SECONDS)
                writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                if (BuildConfig.DEBUG) addInterceptor(
                    HttpLoggingInterceptor().setLevel(
                        HttpLoggingInterceptor.Level.BODY
                    )
                )
            }
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}