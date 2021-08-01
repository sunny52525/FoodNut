package com.shaun.foodnut.models.foodparser

data class FoodParsed(
    val _links: Links,
    val hints: List<Hint>,
    val parsed: List<Parsed>,
    val text: String
)