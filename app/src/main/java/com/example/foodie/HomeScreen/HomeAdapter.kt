package com.example.foodie.HomeScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodie.RestaurantResponse
import com.example.foodie.databinding.RestaurantCellBinding

class HomeAdapter(val myRestaurantList : ArrayList<RestaurantResponse>): RecyclerView.Adapter<HomeAdapter.viewHolder>() {

   inner class viewHolder(val cellBinding: RestaurantCellBinding):RecyclerView.ViewHolder(cellBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.viewHolder {
        return viewHolder(RestaurantCellBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HomeAdapter.viewHolder, position: Int) {
        holder.cellBinding.apply {
            val model = myRestaurantList[position]
            restaurantName.text = model.rName
//            restaurantImg.setImageResource(model.rImage)
            kmText.text = "${model.rKilometers} km"
            ratingBar.rating = model.ratingCount.toFloat()
        }
    }

    override fun getItemCount(): Int {
        return myRestaurantList.size
    }
}