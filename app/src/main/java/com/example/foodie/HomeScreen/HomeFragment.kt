package com.example.foodie.HomeScreen

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodie.ProductListScreen.ProductListActivity
import com.example.foodie.RestaurantResponse
import com.example.foodie.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeAdapter : HomeAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeAdapter = HomeAdapter(requireContext(),arrayListOf(),object : HomeAdapter.OnItemClickListener{
            override fun onItemClick(restaurant: RestaurantResponse) {
                val intent = Intent(requireContext(), ProductListActivity::class.java)
                intent.putExtra("restaurant", restaurant as Parcelable)
                startActivity(intent)
            }
        })

        binding.rvRestaurants.layoutManager = LinearLayoutManager(context)
        binding.rvRestaurants.adapter = homeAdapter

        viewModel.restaurants.observe(viewLifecycleOwner, Observer<ArrayList<RestaurantResponse>> { restaurants ->
            homeAdapter.myRestaurantList.clear()
            homeAdapter.myRestaurantList.addAll(restaurants)
            homeAdapter.notifyDataSetChanged()
        })

    }

}