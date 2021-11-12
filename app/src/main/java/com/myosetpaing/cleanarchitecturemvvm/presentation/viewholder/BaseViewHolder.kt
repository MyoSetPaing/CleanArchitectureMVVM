package com.myosetpaing.cleanarchitecturemvvm.presentation.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by mspai on 10/11/2021.
 **/

abstract class BaseViewHolder<ItemType>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBindView(data: ItemType)
}