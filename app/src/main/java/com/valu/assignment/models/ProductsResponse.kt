package com.valu.assignment.models

import java.io.Serializable

data class ProductsResponse(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingModel
): Serializable