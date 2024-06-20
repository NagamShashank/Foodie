package com.example.foodie.HomeScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodie.RestaurantResponse
import com.example.foodie.databinding.RestaurantCellBinding
import kotlinx.coroutines.withContext

class HomeAdapter(val context: Context,
                  val myRestaurantList : ArrayList<RestaurantResponse>,
                  private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<HomeAdapter.viewHolder>() {


    interface OnItemClickListener {
        fun onItemClick(restaurant: RestaurantResponse)
    }

   inner class viewHolder(val cellBinding: RestaurantCellBinding):RecyclerView.ViewHolder(cellBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.viewHolder {
        return viewHolder(RestaurantCellBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HomeAdapter.viewHolder, position: Int) {

        val model = myRestaurantList[position]
        holder.cellBinding.apply {
            restaurantName.text = model.rName
//            restaurantImg.setImageResource(model.rImage)
            kmText.text = "${model.rKilometers} km"
            ratingBar.rating = model.ratingCount!!.toFloat()
            Glide.with(context)
                .load(model.rImage)
                .into(restaurantImg)
        }

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(model)
        }
    }

    override fun getItemCount(): Int {
        return myRestaurantList.size
    }
}