package com.shaun.foodnut.models.nutrients

data class Parsed(
    val food: String,
    val foodContentsLabel: String,
    val foodId: String,
    val measure: String,
    val measureURI: String,
    val quantity: Int,
    val retainedWeight: Double,
    val status: String,
    val weight: Double
)