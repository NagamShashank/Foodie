package com.example.foodie.MyBagScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodie.R
import com.example.foodie.databinding.FragmentMyBagBinding


class MyBagFragment : Fragment() {

    private lateinit var binding : FragmentMyBagBinding
    private lateinit var myBagAdapter : MyBagAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyBagBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MyBagViewModel()::class.java)
        myBagAdapter = MyBagAdapter(viewModel.myBagList)
        binding.myOrderRv.layoutManager = LinearLayoutManager(context)
        binding.myOrderRv.adapter = myBagAdapter
    }

}