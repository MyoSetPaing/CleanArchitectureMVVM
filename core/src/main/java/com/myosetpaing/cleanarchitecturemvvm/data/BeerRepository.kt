package com.myosetpaing.cleanarchitecturemvvm.data

/**
 * Created by mspai on 10/11/2021.
 **/

class BeerRepository(private val beerRemoteDataSource: BeerRemoteDataSource) {
    suspend fun fetchBeerList() = beerRemoteDataSource.fetchBeerList()
//    suspend fun getBeerList() = beerLocalDataSource.getBeerList()

}