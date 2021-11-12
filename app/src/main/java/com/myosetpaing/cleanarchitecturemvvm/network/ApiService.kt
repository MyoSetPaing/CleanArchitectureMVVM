package com.myosetpaing.cleanarchitecturemvvm.network

import com.myosetpaing.cleanarchitecturemvvm.domain.BeerVO
import retrofit2.http.GET

/**
 * Created by mspai on 10/11/2021.
 **/

interface ApiService {
    @GET("v2/beers")
    suspend fun getBeerList(): List<BeerVO>
}