package com.valu.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.valu.assignment.R
import com.valu.assignment.databinding.ItemProductBinding
import com.valu.assignment.models.ProductsResponse

class ProductsAdapter(private val context: Context, private val productsList: List<ProductsResponse>, val productClickInterface: ProductClickInterface):
    RecyclerView.Adapter<ProductsAdapter.ProductHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(context, productsList[position])
    }

    override fun getItemCount(): Int = productsList.size

    inner class ProductHolder(private val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        fun bind(context: Context, productsResponse: ProductsResponse){
            binding.tvTitle.text = productsResponse.title
            binding.tvPrice.text = productsResponse.price.toString() + " " + context.getString(R.string.STR_EGP)
            Glide.with(context).load(productsResponse.image).fitCenter().error(R.drawable.ic_baseline_error_24).centerInside().into(binding.ivItem)
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            productClickInterface.onProductClick(adapterPosition)
        }

    }

    interface ProductClickInterface{
        fun onProductClick(position: Int)
    }
}