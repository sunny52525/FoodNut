package com.shaun.foodnut.models.foodparser

data class Food(
    val brand: String,
    val category: String,
    val categoryLabel: String,
    val foodContentsLabel: String,
    val foodId: String,
    val image: String,
    val label: String,
    val nutrients: Nutrients,
    val servingSizes: List<ServingSize>,
    val servingsPerContainer: Int,
    val healthLabels:ArrayList<String>?,
)