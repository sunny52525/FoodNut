package com.shaun.foodnut.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.NavHostFragment
import coil.annotation.ExperimentalCoilApi
import com.shaun.foodnut.models.recipes.RecipeObject
import com.shaun.foodnut.ui.navigation.Routes
import com.shaun.foodnut.ui.screens.HomeScreen
import com.shaun.foodnut.ui.screens.ProfileScreen
import com.shaun.foodnut.ui.screens.RecipeDetailScreen
import com.shaun.foodnut.ui.screens.SearchScreen
import com.shaun.foodnut.ui.theme.Dimens.grid_2_5
import com.shaun.foodnut.viewmodels.HomeViewModel
import com.shaun.foodnut.viewmodels.SearchViewModel

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun NavigationGraph(
    homeViewModel: HomeViewModel,
    paddingValues: PaddingValues,
    navController:NavHostController,
    onDrawerClicked: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
        modifier = Modifier.padding(top = grid_2_5)
    ) {


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
                navController = navController,
                onSearchClicked = {
                    navController.navigate(Routes.SearchScreen.route)
                }
            )
        }

        composable(Routes.RecipeDetail.route) {
            val recipe =
                navController.previousBackStackEntry?.arguments?.getParcelable<RecipeObject>("recipe")

            if (recipe != null) {
                RecipeDetailScreen(recipe = recipe, onBackClicked = {
                    navController.popBackStack()
                }, onFavouriteClicked = {

                })
            }
        }

        composable(Routes.SearchScreen.route) {
            val searchViewModel = hiltViewModel<SearchViewModel>()

            SearchScreen(
                Modifier.padding(paddingValues = paddingValues),
                viewModel = searchViewModel
            )
        }
        composable(Routes.Profile.route) {
            ProfileScreen()
        }
    }
}