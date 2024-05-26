package com.example.foodie.MyBagScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodie.databinding.MyBagProductCellBinding
import com.example.foodie.databinding.MyOrderCellBinding

class MyBagAdapter(val myBagList : ArrayList<MyBagModel>): RecyclerView.Adapter<MyBagAdapter.viewHolder>() {

    inner class viewHolder(val cellBinding: MyBagProductCellBinding):RecyclerView.ViewHolder(cellBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBagAdapter.viewHolder {
        return viewHolder(MyBagProductCellBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyBagAdapter.viewHolder, position: Int) {
        holder.cellBinding.apply {
            val model = myBagList[position]
            productImg.setImageResource(model.productImg)
            productName.text = model.productName
            productPrice.text = model.productPrice
        }
    }

    override fun getItemCount(): Int { return myBagList.size }
}