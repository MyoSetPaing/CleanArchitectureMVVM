package com.myosetpaing.cleanarchitecturemvvm.presentation.viewholder

import android.view.View
import coil.load
import com.myosetpaing.cleanarchitecturemvvm.databinding.ItemViewBeerBinding
import com.myosetpaing.cleanarchitecturemvvm.domain.BeerVO

/**
 * Created by mspai on 11/11/2021.
 **/

class BeerViewHolder(itemView: View) : BaseViewHolder<BeerVO>(itemView) {
    override fun onBindView(data: BeerVO) {
        val binding = ItemViewBeerBinding.bind(itemView)
        binding.tvBeerName.text = data.name
        binding.ivBeer.load(data.image_url)
    }
}