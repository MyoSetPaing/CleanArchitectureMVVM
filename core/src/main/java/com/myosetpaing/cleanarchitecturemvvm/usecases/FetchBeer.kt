package com.myosetpaing.cleanarchitecturemvvm.usecases

import com.myosetpaing.cleanarchitecturemvvm.data.BeerRepository

/**
 * Created by mspai on 10/11/2021.
 **/

class FetchBeer(private val beerRepository: BeerRepository) {
    suspend operator fun invoke() = beerRepository.fetchBeerList()
}