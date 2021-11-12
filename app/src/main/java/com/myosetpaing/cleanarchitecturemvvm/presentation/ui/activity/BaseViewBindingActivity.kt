package com.myosetpaing.cleanarchitecturemvvm.presentation.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

/**
 * Created by mspai on 10/11/2021.
 **/

abstract class BaseViewBindingActivity<VB : ViewBinding, VM : ViewModel> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected abstract val viewModel: VM
    abstract fun bindView(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindView(layoutInflater)
        setContentView(binding.root)
    }

    override fun setTitle(@StringRes titleId: Int) {
        title = getString(titleId)
    }
    

}