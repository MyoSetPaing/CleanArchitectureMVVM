package com.myosetpaing.cleanarchitecturemvvm.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myosetpaing.cleanarchitecturemvvm.presentation.viewholder.BaseViewHolder
import java.util.ArrayList

/**
 * Created by mspai on 10/11/2021.
 **/


abstract class BaseRecyclerViewAdapter<ItemType : BaseViewHolder<D>, D> : RecyclerView.Adapter<ItemType>() {

    private var mDataList: MutableList<D> = ArrayList()

    abstract fun onCreateView(parent: ViewGroup, viewType: Int): ItemType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemType =
        onCreateView(parent,viewType)


    override fun onBindViewHolder(viewHolder: ItemType, position: Int) {
        viewHolder.onBindView(mDataList[position])
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    fun setData(newData: MutableList<D>) {
        mDataList = newData
        notifyDataSetChanged()
    }

    fun appendData(newData: List<D>) {
        mDataList.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): D? {
        return if (position < mDataList.size - 1) mDataList[position] else null

    }

    fun removeData(data: D) {
        mDataList.remove(data)
        notifyDataSetChanged()
    }

    fun addNewData(data: D) {
        mDataList.add(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        mDataList = ArrayList()
        notifyDataSetChanged()
    }
}