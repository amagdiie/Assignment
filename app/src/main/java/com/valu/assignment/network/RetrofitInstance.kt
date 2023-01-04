package com.valu.assignment.network

object RetrofitInstance {
    val api : ApiInterface by lazy {
        ApiClient().getRetrofitGson().create(ApiInterface::class.java)
    }
}