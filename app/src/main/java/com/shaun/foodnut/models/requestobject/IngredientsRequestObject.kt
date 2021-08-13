package com.shaun.foodnut.models.requestobject

data class IngredientsRequestObject(
    val ingredients:ArrayList<IngredientRequestObject>,
){
    data class IngredientRequestObject(
        val quantity:Int,
        val measureURI:String,
        val foodId:String,
    )
}
