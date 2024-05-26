package com.example.foodie.MyOrdersScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodie.Repository.MainRepository
import com.example.foodie.RestaurantResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyOrderViewModel : ViewModel() {

//    val myOrderList : ArrayList<MyOrderModel> = ArrayList()
//
//    init {
//        myOrderList.add(MyOrderModel("The Pizza Place",50.00,1,"progress"))
//        myOrderList.add(MyOrderModel("Hakka Chinese",100.00,2,"delivered"))
//        myOrderList.add(MyOrderModel("The Ice-Cream Factory",40.00,1,"cancelled"))
//        myOrderList.add(MyOrderModel("Burger King",60.00,1,"progress"))
//        myOrderList.add(MyOrderModel("The Pizza Place",50.00,1,"progress"))
//        myOrderList.add(MyOrderModel("The Dosa King",120.00,1,"delivered"))
//        myOrderList.add(MyOrderModel("The Ice-Cream Factory",40.00,1,"cancelled"))
//        myOrderList.add(MyOrderModel("Burger King",60.00,1,"progress"))
//    }

    private val repository = MainRepository()
    private val _myOrders = MutableLiveData<ArrayList<MyOrderModel>>()
    val myOrders: LiveData<ArrayList<MyOrderModel>>
        get() = _myOrders

    init {
        loadMyOrders()
    }

    private fun loadMyOrders(){
        viewModelScope.launch(Dispatchers.IO) {
            _myOrders.postValue(repository.getMyOrders())
        }
    }
}