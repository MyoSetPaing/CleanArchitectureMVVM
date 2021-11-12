package com.myosetpaing.cleanarchitecturemvvm.framework.di

import com.myosetpaing.cleanarchitecturemvvm.presentation.viewmodel.BeerViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by mspai on 11/11/2021.
 **/

val presentationModule = module {
    viewModel { BeerViewModel(get(),get()) }
}