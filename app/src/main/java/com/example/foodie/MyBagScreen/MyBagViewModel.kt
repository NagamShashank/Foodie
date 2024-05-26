package com.example.foodie.MyBagScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.foodie.R

class MyBagViewModel : ViewModel() {

    val myBagList : ArrayList<MyBagModel> = ArrayList()
    init {
        myBagList.add(MyBagModel(R.drawable.pizza_1,"King Pizza","Rs 50"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"Magherita Pizza","Rs 40"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"Cheese Pizza","Rs 80"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"Chicken Chilly Pizza ","Rs 100"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"Sweet Corn Pizza","Rs 80"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"King Pizza","Rs 60"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"King Pizza","Rs 50"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"Magherita Pizza","Rs 40"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"Cheese Pizza","Rs 80"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"Chicken Chilly Pizza ","Rs 100"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"Sweet Corn Pizza","Rs 80"))
        myBagList.add(MyBagModel(R.drawable.pizza_1,"King Pizza","Rs 60"))
    }
}