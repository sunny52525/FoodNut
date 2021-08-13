package com.shaun.foodnut.models

data class ErrorsItem(
    val errorCode: String,
    val message: String,
    val params: List<String>
)