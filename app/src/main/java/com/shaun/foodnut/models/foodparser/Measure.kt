package com.shaun.foodnut.models.foodparser

data class Measure(
    val label: String,
    val qualified: List<Qualified>,
    val uri: String,
    val weight: Int
)