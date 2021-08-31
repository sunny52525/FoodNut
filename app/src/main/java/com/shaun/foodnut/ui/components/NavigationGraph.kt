package com.shaun.foodnut.ui.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.shaun.foodnut.models.recipes.RecipeObject
import com.shaun.foodnut.ui.navigation.Routes
import com.shaun.foodnut.ui.screens.HomeScreen
import com.shaun.foodnut.ui.screens.RecipeDetailScreen
import com.shaun.foodnut.viewmodels.HomeViewModel

@ExperimentalCoilApi
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
                onDrawerClicked = onDrawerClicked,
                navController = navController
            )
        }

        composable(Routes.RecipeDetail.route) {
            val recipe =
                navController.previousBackStackEntry?.arguments?.getParcelable<RecipeObject>("recipe")

            Log.d("NAVCONTROLLER", "NavigationGraph: $recipe " +
                    "${navController.previousBackStackEntry?.arguments}")
            if (recipe != null) {
                RecipeDetailScreen(recipe =recipe)
            }else{
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Header(text = "Error ")
                }
            }
        }
    })
}