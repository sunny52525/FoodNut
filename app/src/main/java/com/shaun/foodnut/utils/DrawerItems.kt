package com.shaun.foodnut.utils


sealed class DrawerItems(val name: String) {
    object Home : DrawerItems("Home")
    object Favourites : DrawerItems("Favourites")
    object Search : DrawerItems("Search")
    object AddRecipe : DrawerItems("Add Recipe")
    object RecipeCommunity : DrawerItems("Posts")
    object Profile : DrawerItems("Profile")

}
