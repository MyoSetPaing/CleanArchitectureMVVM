package com.myosetpaing.cleanarchitecturemvvm.framework.di

import com.myosetpaing.cleanarchitecturemvvm.BuildConfig
import com.myosetpaing.cleanarchitecturemvvm.data.BeerRepository
import com.myosetpaing.cleanarchitecturemvvm.framework.Interactors
import com.myosetpaing.cleanarchitecturemvvm.framework.RemoteDataSource
import com.myosetpaing.cleanarchitecturemvvm.network.ApiService
import com.myosetpaing.cleanarchitecturemvvm.usecases.FetchBeer
import com.myosetpaing.cleanarchitecturemvvm.usecases.GetBeer
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by mspai on 10/11/2021.
 **/

val repositoryModule = module {
    single { provideLoggingInterceptor() }
    single { provideApiInterface(get()) }
    single { provideRemoteSource(get()) }
    single { provideBeerRepository(get()) }
    single { provideInteractors(get()) }

}

fun provideRemoteSource(api: ApiService): RemoteDataSource {
    return RemoteDataSource(api)
}
private fun provideApiInterface(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

private fun provideBeerRepository(
    beerRemoteDataSource: RemoteDataSource,
): BeerRepository {
    return BeerRepository(beerRemoteDataSource)
}

private fun provideInteractors(beerRepository: BeerRepository): Interactors {
    return Interactors(
        GetBeer(beerRepository),
        FetchBeer(beerRepository)
    )
}
fun provideLoggingInterceptor(): HttpLoggingInterceptor =if (BuildConfig.DEBUG)
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
else
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)