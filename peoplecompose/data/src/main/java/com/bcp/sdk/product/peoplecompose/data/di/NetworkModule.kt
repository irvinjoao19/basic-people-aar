package com.bcp.sdk.product.peoplecompose.data.di

import com.bcp.sdk.product.peoplecompose.data.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    private var instance: Retrofit? = null

    @Provides
    internal fun provideRetrofit(
        gsonConverter: GsonConverterFactory,
        rxJava: RxJava3CallAdapterFactory,
    ): Retrofit = instance
        ?: synchronized(this) {
            val retrofit by lazy {
                Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(gsonConverter)
                    .addCallAdapterFactory(rxJava)
                    .build()
            }
            instance = retrofit
            retrofit
        }

    @Provides
    internal fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().setLenient().create())
    }

    @Provides
    internal fun providesRxJavaCallAdapterFactory(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.create()
    }

    @Provides
    internal fun provideService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    internal fun provideGson(): Gson {
        return Gson()
    }

    companion object {
        private const val BASE_URL = "https://reqres.in/"
    }
}