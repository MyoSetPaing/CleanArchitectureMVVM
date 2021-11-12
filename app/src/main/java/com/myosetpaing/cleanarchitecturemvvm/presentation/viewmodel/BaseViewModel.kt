package com.myosetpaing.cleanarchitecturemvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import timber.log.Timber

/**
 * Created by mspai on 10/11/2021.
 **/

abstract class BaseViewModel: ViewModel() {
    protected  val loggingExceptionHandler = CoroutineExceptionHandler{_,t->
        Timber.i(t)
    }
    fun detachView(){
        viewModelScope.cancel()
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}