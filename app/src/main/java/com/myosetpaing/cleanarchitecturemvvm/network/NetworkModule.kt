package com.myosetpaing.cleanarchitecturemvvm.network

import android.content.Context
import com.myosetpaing.cleanarchitecturemvvm.BuildConfig
import com.myosetpaing.cleanarchitecturemvvm.utils.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by mspai on 10/11/2021.
 **/

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideNetworkHelper(androidContext()) }
    single { provideRetrofit(get(), BuildConfig.BASE_URL) }
}

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        /*.addInterceptor(loggingInterceptor)*/
        .build()
} else OkHttpClient.Builder().build()

private fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

