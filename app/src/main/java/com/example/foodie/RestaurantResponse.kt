package com.example.foodie

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RestaurantResponse(
    @SerializedName("rImage") val rImage: String,
    @SerializedName("rName") val rName: String,
    @SerializedName("rKilometers") val rKilometers: String,
    @SerializedName("ratingCount") val ratingCount: String
):Serializable
