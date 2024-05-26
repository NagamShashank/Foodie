package com.example.foodie.ApiService

import com.example.foodie.RestaurantResponse
import com.example.foodie.Model.BaseModel
import com.example.foodie.MyOrdersScreen.MyOrderModel
import retrofit2.http.GET

interface MainApiService {

    @GET("restaurants")
    suspend fun getRestaurants(): BaseModel<RestaurantResponse>

    @GET("MyOrders")
    suspend fun getMyOrders(): BaseModel<MyOrderModel>
}