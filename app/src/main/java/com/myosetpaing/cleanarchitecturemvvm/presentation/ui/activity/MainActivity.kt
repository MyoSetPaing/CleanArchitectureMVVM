package com.myosetpaing.cleanarchitecturemvvm.presentation.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.myosetpaing.cleanarchitecturemvvm.databinding.ActivityMainBinding
import com.myosetpaing.cleanarchitecturemvvm.presentation.adapter.BeerRecyclerViewAdapter
import com.myosetpaing.cleanarchitecturemvvm.presentation.viewmodel.BeerViewModel
import com.myosetpaing.cleanarchitecturemvvm.utils.Status
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : BaseViewBindingActivity<ActivityMainBinding, BeerViewModel>() {

    private val mAdapter by lazy {
        BeerRecyclerViewAdapter(this)
    }
    private val mLayoutManager by lazy {
        GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
    }


    override val viewModel: BeerViewModel by viewModel()

    override fun bindView(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        setUpRecyclerView()
        observeViewModel()
    }

    private fun setUpRecyclerView() {
        binding.rvBeerList.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeViewModel() {
        viewModel.beerDataResponse.observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.rvBeerList.visibility = View.VISIBLE
                    try {
                        it.data?.let { data ->
                            mAdapter.setData(data.toMutableList())
                            Timber.d("Item count ${mAdapter.itemCount}")
                        }
                    } catch (e: Exception) {
                        Timber.e(e)
                    }
                }
                Status.LOADING -> {
                    binding.rvBeerList.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.rvBeerList.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }


}