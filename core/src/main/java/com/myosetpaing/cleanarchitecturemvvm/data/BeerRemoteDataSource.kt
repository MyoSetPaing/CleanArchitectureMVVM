package com.myosetpaing.cleanarchitecturemvvm.data

import com.myosetpaing.cleanarchitecturemvvm.domain.BeerVO
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

/**
 * Created by mspai on 10/11/2021.
 **/

interface BeerRemoteDataSource {
    @FlowPreview
    suspend fun fetchBeerList(): Flow<List<BeerVO>>
}