package com.myosetpaing.cleanarchitecturemvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.myosetpaing.cleanarchitecturemvvm.domain.BeerVO
import com.myosetpaing.cleanarchitecturemvvm.framework.Interactors
import com.myosetpaing.cleanarchitecturemvvm.utils.NetworkHelper
import com.myosetpaing.cleanarchitecturemvvm.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by mspai on 10/11/2021.
 **/

class BeerViewModel(
    private val interactors: Interactors,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {
    private var _beerDataResponse = MutableLiveData<Resource<List<BeerVO>>>()
    val beerDataResponse: LiveData<Resource<List<BeerVO>>>
        get() = _beerDataResponse

    init {
        fetchBeer()
    }

    private fun fetchBeer() {
        viewModelScope.launch(Dispatchers.IO) {
            _beerDataResponse.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
               try {
                   interactors.fetchBeer().let { data ->
                       _beerDataResponse.postValue(Resource.success(data))
                   }
               } catch (e: Exception) {
                   e.printStackTrace()
               }
            }
        }
    }
}