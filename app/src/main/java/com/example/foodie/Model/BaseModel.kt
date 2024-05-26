package com.example.foodie.Model

import org.json.JSONObject

data class BaseModel<T>(var Status : Int,var Message : String, var Data : ArrayList<T>)

