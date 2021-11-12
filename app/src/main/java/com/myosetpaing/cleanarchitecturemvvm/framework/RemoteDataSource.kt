package com.myosetpaing.cleanarchitecturemvvm.framework

import com.myosetpaing.cleanarchitecturemvvm.data.BeerRemoteDataSource
import com.myosetpaing.cleanarchitecturemvvm.domain.BeerVO
import com.myosetpaing.cleanarchitecturemvvm.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by mspai on 11/11/2021.
 **/

class RemoteDataSource(private val apiService: ApiService) : BeerRemoteDataSource {
    override suspend fun fetchBeerList(): Flow<List<BeerVO>> = flow {
        val response = apiService.getBeerList()
        emit(response)
    }
}