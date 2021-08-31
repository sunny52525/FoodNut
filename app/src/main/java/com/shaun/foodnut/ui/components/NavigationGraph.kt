package com.shaun.foodnut.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shaun.foodnut.ui.navigation.Routes
import com.shaun.foodnut.ui.screens.HomeScreen
import com.shaun.foodnut.viewmodels.HomeViewModel

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun NavigationGraph(
    homeViewModel: HomeViewModel,
    paddingValues: PaddingValues,
    onDrawerClicked: () -> Unit,
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home.route, builder = {
        composable(Routes.Home.route) {
            val foodItems by homeViewModel.foodItems.observeAsState()
            val selectedItem = homeViewModel.selectedItem
            val recipes by homeViewModel.recipes.observeAsState()

            HomeScreen(
                foodItems = foodItems,
                onChipItemChanged = {
                    if (selectedItem != it) {
                        homeViewModel.selectedItem = it
                        homeViewModel.updateHomeScreen()
                    }

                },
                selectedItem = selectedItem,
                recipes = recipes,
                modifier = Modifier.padding(paddingValues = paddingValues),
                onDrawerClicked = onDrawerClicked
            )
        }
    })
}