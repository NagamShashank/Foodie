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