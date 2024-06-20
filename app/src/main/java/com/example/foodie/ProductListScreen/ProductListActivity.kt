package com.example.foodie.ProductListScreen

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodie.R
import com.example.foodie.RestaurantResponse
import com.example.foodie.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.WHITE
        }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        loadResData()
    }

    private fun loadResData(){
        val restaurant: RestaurantResponse? = intent.getParcelableExtra("restaurant")
    }
}