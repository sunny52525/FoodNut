package com.shaun.foodnut.ui.screens

import android.os.Bundle
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.shaun.foodnut.network.Status
import com.shaun.foodnut.ui.components.*
import com.shaun.foodnut.ui.navigation.Routes
import com.shaun.foodnut.ui.theme.Dimens.grid_1
import com.shaun.foodnut.ui.theme.Dimens.grid_2
import com.shaun.foodnut.ui.theme.Dimens.grid_3
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.utils.Constants
import com.shaun.foodnut.viewmodels.SearchViewModel

@OptIn(ExperimentalCoilApi::class)
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel,
    navController: NavHostController,
) {

    var currentType by viewModel.currentType

    val itemsAdded by viewModel.itemsAdded
    var query by viewModel.searchQuery
    var resultsVisible by remember {
        mutableStateOf(false)
    }


    val recipes by viewModel.recipeResponse.observeAsState()


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                FoodNutColors.Background
            )
            .padding(top = 40.dp, start = grid_2, end = grid_3, bottom = grid_1)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SearchBar(
                query = query,
                onValueChange = {
                    query = it
                },
                onSearch = { viewModel.search() },
                modifier = Modifier.weight(1.5f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            DropDownSelector(
                modifier = Modifier.weight(0.5f),
                showType = false,
                dropdownContent = Constants.category,
                title = currentType, onclick = {
                    currentType = it
                }
            )
        }

        when (recipes?.status) {
            Status.SUCCESS -> {
                LazyColumn(content = {

                    recipes?.data?.hits?.forEach {
                        item {
                            FoodCardHorizontal(
                                image = rememberImagePainter(data = it.recipe.image),
                                title = it.recipe.label,
                                subtitle = it.recipe.source,
                                isFavourite = true,
                                onClick = {
                                    navController.currentBackStackEntry?.arguments =
                                        Bundle().apply {
                                            putParcelable("recipe", it.recipe)
                                        }
                                    navController.navigate(Routes.RecipeDetail.route)
                                },
                                bottomText = "${it.recipe.totalNutrients.ENERC_KCAL?.quantity?.toInt()} KCAL"
                            ) {

                            }
                        }
                    }


                })
            }
            Status.ERROR -> {
                Text("Error")
            }
            Status.LOADING -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LinearProgressIndicator(
                        color = FoodNutColors.Green,

                    )
                }
            }
            Status.IDLE -> {

                LazyColumn {
                    item {
                        SearchScreenTopArea(viewModel)
                    }
                    item {

                        SearchScreenMoreFilters(itemsAdded = itemsAdded, onclick = {
                            itemsAdded.add(it)

                        }, onAddMore = {

                        }, onDeleteItem = {
                            itemsAdded.remove(it)

                        })
                    }
                }
            }
            null -> {
                Text("Error")
            }
        }

    }
}
