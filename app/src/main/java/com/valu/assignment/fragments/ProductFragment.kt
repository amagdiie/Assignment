package com.valu.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.valu.assignment.R
import com.valu.assignment.databinding.FragmentProductBinding
import com.valu.assignment.models.ProductsResponse

class ProductFragment(private val productResponse: ProductsResponse) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentProductBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        binding.tvProductTitle.text = productResponse.title
        binding.tvProductDesc.text = productResponse.description
        binding.tvProductPrice.text = productResponse.price.toString() + " " + getString(R.string.STR_EGP)
        binding.tvRatingCount.text = productResponse.rating.count.toString()
        binding.rbRating.rating = productResponse.rating.rate.toFloat()
        context?.let { Glide.with(it).load(productResponse.image).fitCenter().error(R.drawable.ic_baseline_error_24).centerInside().into(binding.ivProductImage) }
    }

    override fun getTheme(): Int {
        return R.style.NewAppBottomSheetDialogTheme
    }
}