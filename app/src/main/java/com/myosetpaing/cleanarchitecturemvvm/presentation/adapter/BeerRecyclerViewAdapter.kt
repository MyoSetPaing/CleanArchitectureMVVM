package com.myosetpaing.cleanarchitecturemvvm.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.cleanarchitecturemvvm.R
import com.myosetpaing.cleanarchitecturemvvm.domain.BeerVO
import com.myosetpaing.cleanarchitecturemvvm.presentation.viewholder.BeerViewHolder

/**
 * Created by mspai on 11/11/2021.
 **/

class BeerRecyclerViewAdapter(private val context: Context) :
    BaseRecyclerViewAdapter<BeerViewHolder, BeerVO>() {
    override fun onCreateView(parent: ViewGroup, viewType: Int): BeerViewHolder =
        BeerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view_beer, parent, false)
        )

}