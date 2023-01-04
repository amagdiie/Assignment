package com.valu.assignment.network

import com.valu.assignment.const.Constants.Apis.PRODUCTS
import com.valu.assignment.models.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(PRODUCTS)
    fun getProducts(): Call<List<ProductsResponse>>
}