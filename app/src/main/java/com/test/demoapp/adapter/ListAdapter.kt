package com.test.demoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.demoapp.R
import com.test.demoapp.databinding.ListItemBinding
import com.test.demoapp.model.Restaurants

internal class ListAdapter(context: Context) : RecyclerView.Adapter<ListAdapter.ItemHolder>() {

    private var restaurantList = ArrayList<Restaurants>()
    private var layoutInflater: LayoutInflater

    init {
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.list_item,
            parent, false
        )
        return ItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.itemBinding.restaurant = restaurantList[position].restaurant

    }

    internal fun setListData(listMyActivity: List<Restaurants>) {
        this.restaurantList = listMyActivity as ArrayList<Restaurants>
        notifyDataSetChanged()
    }


    internal class ItemHolder(pdfFileBinding: ListItemBinding) :
        RecyclerView.ViewHolder(pdfFileBinding.getRoot()) {
        var itemBinding: ListItemBinding = pdfFileBinding
    }


}