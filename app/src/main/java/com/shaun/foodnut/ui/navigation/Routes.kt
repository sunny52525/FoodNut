package com.shaun.foodnut.ui.navigation


sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Favourites : Routes("favourite")
    object Profile : Routes("profile")
    object Posts : Routes("posts")
    object FoodDetails : Routes("food_details")
    object RecipeDetail : Routes("recipe_detail")
    object SearchScreen : Routes("search_screen")
}