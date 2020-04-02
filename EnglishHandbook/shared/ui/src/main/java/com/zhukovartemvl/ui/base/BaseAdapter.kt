package com.zhukovartemvl.ui.base

import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


abstract class BaseAdapter<P> : RecyclerView.Adapter<BaseViewHolder<P>>() {
    protected var mDataList: MutableList<P> = ArrayList()
    protected var mCallback: BaseAdapterCallback<P>? = null

    fun attachCallback(callback: BaseAdapterCallback<P>) {
        this.mCallback = callback
    }

    fun detachCallback() {
        this.mCallback = null
    }

    fun setList(dataList: List<P>) {
        val start = mDataList.size
        mDataList.addAll(dataList)
        notifyItemRangeInserted(start, dataList.size)
    }

    fun updateItem(item: P) {
        val id = mDataList.indexOf(item)
        if (id != -1) {
            mDataList[id] = item
            notifyItemChanged(id)
        }
    }

    fun addItem(newItem: P) {
        mDataList.add(newItem)
        notifyItemInserted(mDataList.size - 1)
    }

    fun addItemToTop(newItem: P) {
        mDataList.add(0, newItem)
        notifyItemInserted(0)
    }

    fun updateItems(itemsList: List<P>) {
        val size = mDataList.size
        mDataList.clear()
        notifyItemRangeRemoved(0, size)
        setList(itemsList)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<P>, position: Int) {
        holder.bind(mDataList[position])

        holder.itemView.setOnClickListener {
            mCallback?.onItemClick(mDataList[position], holder.itemView)
        }
        holder.itemView.setOnLongClickListener {
            if (mCallback != null)
                mCallback!!.onLongClick(mDataList[position], holder.itemView)
            else
                true
        }
    }

    override fun getItemCount() = mDataList.size

}
