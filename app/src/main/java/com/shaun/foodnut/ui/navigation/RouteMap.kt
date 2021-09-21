package com.shaun.foodnut.ui.navigation

import com.shaun.foodnut.utils.DrawerItems


object RouteMap {
    fun getRoute(name: String): String {

        return when (name) {
            DrawerItems.AddRecipe.name -> Routes.AddRecipe.route
            DrawerItems.Favourites.name -> Routes.Favourites.route
            DrawerItems.Home.name -> Routes.Home.route
            DrawerItems.Profile.name -> Routes.Profile.route
            DrawerItems.RecipeCommunity.name -> Routes.Posts.route
            DrawerItems.Search.name -> Routes.SearchScreen.route
            else -> {
                throw IllegalArgumentException()
            }
        }

    }
}