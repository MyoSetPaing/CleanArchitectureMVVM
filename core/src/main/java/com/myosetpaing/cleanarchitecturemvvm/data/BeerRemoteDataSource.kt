package com.myosetpaing.cleanarchitecturemvvm.data

import com.myosetpaing.cleanarchitecturemvvm.domain.BeerVO

/**
 * Created by mspai on 10/11/2021.
 **/

interface BeerRemoteDataSource {
    suspend fun fetchBeerList(): List<BeerVO>
}