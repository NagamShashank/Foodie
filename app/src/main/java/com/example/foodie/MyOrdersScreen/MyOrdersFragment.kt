package com.example.foodie.MyOrdersScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodie.HomeScreen.HomeAdapter
import com.example.foodie.HomeScreen.HomeViewModel
import com.example.foodie.R
import com.example.foodie.RestaurantResponse
import com.example.foodie.databinding.FragmentMyOrdersBinding


class MyOrdersFragment : Fragment() {

    private lateinit var binding : FragmentMyOrdersBinding
    private lateinit var myOrderAdapter : MyOrderAdapter
    private val viewModel: MyOrderViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyOrdersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myOrderAdapter = MyOrderAdapter(arrayListOf())
        binding.rvMyOrders.layoutManager = LinearLayoutManager(context)
        binding.rvMyOrders.adapter = myOrderAdapter

        viewModel.myOrders.observe(viewLifecycleOwner, Observer<ArrayList<MyOrderModel>>{ myOrders->
            myOrderAdapter.myOrderList.clear()
            myOrderAdapter.myOrderList.addAll(myOrders)
            myOrderAdapter.notifyDataSetChanged()
        })
    }

}