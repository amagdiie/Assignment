package com.valu.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.valu.assignment.MainActivity
import com.valu.assignment.adapters.ProductsAdapter
import com.valu.assignment.const.Constants.Fragments.PRODUCT_FRAGMENT
import com.valu.assignment.databinding.FragmentProductsBinding
import com.valu.assignment.models.ProductsResponse
import com.valu.assignment.viewModels.ProductsViewModel

class ProductsFragment : Fragment(), ProductsAdapter.ProductClickInterface {

    private lateinit var binding: FragmentProductsBinding
    private lateinit var viewModel: ProductsViewModel
    private lateinit var productsList: List<ProductsResponse>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
        initObserver()
        return binding.root
    }

    private fun initObserver() {
        viewModel.observeProductsLiveData().observe(viewLifecycleOwner){
            if (it != null){
                productsList = it
                val productsAdapter : ProductsAdapter? =
                    context?.let { it1 -> ProductsAdapter(it1, productsList, this) }

                binding.rvProducts.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                binding.rvProducts.setHasFixedSize(false)
                binding.rvProducts.adapter = productsAdapter
            }
        }
        context?.let { viewModel.getProducts(it) }
    }

    override fun onProductClick(position: Int) {
        val productResponse = productsList[position]
        val fragment = ProductFragment(productResponse)
        fragment.isCancelable = true
        fragment.show((activity as MainActivity).supportFragmentManager, PRODUCT_FRAGMENT)
    }

}