package com.shaun.foodnut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaun.foodnut.ui.screens.HomeScreen
import com.shaun.foodnut.ui.theme.FoodnutTheme
import com.shaun.foodnut.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        val homeViewModel: HomeViewModel by viewModels()
        WindowCompat.setDecorFitsSystemWindows(window, false)


        setContent {
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = MaterialTheme.colors.isLight

            SideEffect {
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = useDarkIcons
                )
            }
            FoodnutTheme(darkTheme = false) {


                val foodItems by homeViewModel.foodItems.observeAsState()
                val selectedItem = homeViewModel.selectedItem
                val recipes by homeViewModel.recipes.observeAsState()

                HomeScreen(
                    foodItems = foodItems,
                    onChipItemChanged = {
                        if (selectedItem!=it) {
                            homeViewModel.selectedItem = it
                            homeViewModel.updateHomeScreen()
                        }

                    },
                    selectedItem = selectedItem,
                    recipes = recipes
                )

            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }


}