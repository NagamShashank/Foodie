package com.example.foodie.MyOrdersScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.foodie.R
import com.example.foodie.databinding.MyOrderCellBinding

class MyOrderAdapter(val myOrderList: ArrayList<MyOrderModel>) : RecyclerView.Adapter<MyOrderAdapter.viewHolder>() {

    inner class viewHolder(val cellBinding : MyOrderCellBinding):RecyclerView.ViewHolder(cellBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderAdapter.viewHolder {
        return viewHolder(MyOrderCellBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyOrderAdapter.viewHolder, position: Int) {
        holder.cellBinding.apply {
            val model = myOrderList[position]
            restaurantName.text = model.rName
            totalAmount.text= "₹ ${model.amount}"
            quantity.text = model.quantity.toString()
            orderNo.text = model.orderNo
            val status = model.orderStatus
            if (status == 0){
                orderStatus.text = "Progress"
                orderStatus.setTextColor(ContextCompat.getColor(orderStatus.context, R.color.yellow_progress))
                statusCardView.setCardBackgroundColor(ContextCompat.getColor(statusCardView.context, R.color.yellow_progress))
            }else if(status == 1){
                orderStatus.text = "Delivered"
                orderStatus.setTextColor(ContextCompat.getColor(orderStatus.context, R.color.green_delivered))
                statusCardView.setCardBackgroundColor(ContextCompat.getColor(statusCardView.context, R.color.green_delivered))
            }else if(status == -1){
                orderStatus.text = "Cancelled"
                orderStatus.setTextColor(ContextCompat.getColor(orderStatus.context, R.color.red_cancelled))
                statusCardView.setCardBackgroundColor(ContextCompat.getColor(statusCardView.context, R.color.red_cancelled))
            }
        }
    }

    override fun getItemCount(): Int {
        return myOrderList.size
    }
}