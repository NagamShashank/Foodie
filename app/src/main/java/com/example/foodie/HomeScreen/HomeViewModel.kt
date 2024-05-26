package com.example.foodie.HomeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodie.RestaurantResponse
import com.example.foodie.Repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

//    val myRestaurantList : ArrayList<RestaurantResponse> =  ArrayList()
//    init {
//        myRestaurantList.add(RestaurantResponse(R.drawable.pizza_img,"The Pizza Place","2",4.0))
//        myRestaurantList.add(RestaurantResponse(R.drawable.ice_cream_img,"The Ice-Cream Factory","3",3.0))
//        myRestaurantList.add(RestaurantResponse(R.drawable.burger_img,"Burger King","5",3.5))
//        myRestaurantList.add(RestaurantResponse(R.drawable.coffee_img,"The Coffee Shop","3",4.5))
//        myRestaurantList.add(RestaurantResponse(R.drawable.pizza_img,"Pizza Hut","4",3.5))
//        myRestaurantList.add(RestaurantResponse(R.drawable.chinese,"Hakka Chinese","5",3.0))
//        myRestaurantList.add(RestaurantResponse(R.drawable.dosa_img,"The Dosa King","1",5.0))
//    }

//    private val repository = MainRepository()
//    private val _restaurants = MutableLiveData<Collection<BaseModel<RestaurantResponse>>>()
//    val restaurants: LiveData<Collection<RestaurantResponse>>
//        get() = restaurants
//
//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            _restaurants.postValue(repository.getRestaurants())
//        }
//    }

    private val repository = MainRepository()
    private val _restaurants = MutableLiveData<ArrayList<RestaurantResponse>>()
    val restaurants: LiveData<ArrayList<RestaurantResponse>>
        get() = _restaurants

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        viewModelScope.launch(Dispatchers.IO) {
//            _restaurants.postValue(repository.getRestaurants())
            val restaurants = repository.getRestaurants()
            _restaurants.postValue(restaurants)
        }
    }
}