package com.example.foodie.MyOrdersScreen

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MyOrderModel(
    @SerializedName("rName") val rName: String,
    @SerializedName("orderNo") val orderNo : String,
    @SerializedName("Amount") val amount : Double,
    @SerializedName("Quantity") val quantity :Int,
    @SerializedName("orderStatus") val orderStatus : Int):Serializable {}