package com.valu.assignment.models

import java.io.Serializable

data class RatingModel(
    val rate: Double,
    val count: Int
): Serializable
