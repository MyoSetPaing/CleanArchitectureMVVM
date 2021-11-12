package com.myosetpaing.cleanarchitecturemvvm.framework

import com.myosetpaing.cleanarchitecturemvvm.usecases.FetchBeer
import com.myosetpaing.cleanarchitecturemvvm.usecases.GetBeer

/**
 * Created by mspai on 10/11/2021.
 **/

data class Interactors(
    val getBeer: GetBeer,
    val fetchBeer: FetchBeer
)