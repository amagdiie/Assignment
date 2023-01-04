package com.valu.assignment.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.valu.assignment.models.ProductsResponse
import com.valu.assignment.network.RetrofitInstance
import com.valu.assignment.utils.UiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel: ViewModel() {

    private var productsLiveData = MutableLiveData<List<ProductsResponse>>()

    fun getProducts(context: Context){
        UiUtils.showLoadingDialog(context)
        RetrofitInstance.api.getProducts().enqueue(object : Callback<List<ProductsResponse>?> {
            override fun onResponse(call: Call<List<ProductsResponse>?>, response: Response<List<ProductsResponse>?>) {
                UiUtils.hideLoadingDialog()
                productsLiveData.value = response.body()
            }

            override fun onFailure(call: Call<List<ProductsResponse>?>, t: Throwable) {
                UiUtils.hideLoadingDialog()
                t.message?.let { UiUtils.showErrorDialog(context, it) }
            }

        })
    }

    fun observeProductsLiveData() : LiveData<List<ProductsResponse>> {
        return productsLiveData
    }
}