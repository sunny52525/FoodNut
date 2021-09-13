package com.shaun.foodnut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaun.foodnut.ui.components.Drawer
import com.shaun.foodnut.ui.components.NavigationGraph
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.ui.theme.FoodnutTheme
import com.shaun.foodnut.utils.Constants
import com.shaun.foodnut.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        val homeViewModel: HomeViewModel by viewModels()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val selectedRoute by homeViewModel.selectedRoute

        setContent {
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = MaterialTheme.colors.isLight

            val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
            val coroutineScope = rememberCoroutineScope()


            SideEffect {
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = useDarkIcons
                )
            }


            FoodnutTheme(darkTheme = false) {


                Scaffold(
                    content = {
                        NavigationGraph(
                            homeViewModel = homeViewModel,
                            paddingValues = it,
                            onDrawerClicked = {
                                coroutineScope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    },
                    drawerContent = {
                        Drawer(
                            items = Constants.DRAWER_ITEMS,
                            selectedRoute = selectedRoute,
                            onClick = {

                            })
                    },
                    scaffoldState = scaffoldState,
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            backgroundColor = FoodNutColors.Green
                        ) {
                            Icon(imageVector = Icons.Filled.Camera, contentDescription = "Add",tint = Color.White)


                        }
                    }

                )


            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }


}