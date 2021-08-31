package com.shaun.foodnut.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.shaun.foodnut.models.foodparser.FoodParsed
import com.shaun.foodnut.models.recipes.RecipeResponse
import com.shaun.foodnut.network.Resource
import com.shaun.foodnut.network.Status
import com.shaun.foodnut.ui.components.*
import com.shaun.foodnut.ui.theme.Dimens.SidePadding
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.ui.theme.POPPINS
import com.shaun.foodnut.utils.Constants
import kotlinx.coroutines.launch


@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    foodItems: Resource<FoodParsed>?,
    onChipItemChanged: (String) -> Unit,
    selectedItem: String,
    onDrawerClicked: () -> Unit,
    recipes: Resource<RecipeResponse>?
) {


    val chipsScrollState = rememberLazyListState()

    val scope = rememberCoroutineScope()


    LazyColumn(
        modifier
            .fillMaxSize()
            .background(FoodNutColors.GenericBackground),
        verticalArrangement = Arrangement.spacedBy(10.dp),


        ) {
        item {
            Spacer(modifier = Modifier.height(40.dp))
            CustomizedTopBar(
                leftIcon = Icons.Filled.Sort,
                rightIcon = Icons.Filled.AccountCircle,
                leftClick = onDrawerClicked, rightClick = {

                })
        }


        item {
            TopArea(modifier = Modifier.padding(horizontal = SidePadding)) {

                Greeting(time = "Good Morning", name = "Sunny")
                SearchPlaceholder(placeholder = "Search Recipes,foods,nutrients", onClick = {

                })
            }
        }

        item {
            Suggestions() {
                LazyRow(
                    Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    state = chipsScrollState
                ) {

                    scope.launch {
                        chipsScrollState.animateScrollToItem(
                            Constants.CHIPS.indexOfFirst {
                                it.label == selectedItem
                            }
                        )
                    }
                    items(Constants.CHIPS, key = {
                        it.label
                    }) {
                        SelectableChips(
                            icon = painterResource(id = it.icon),
                            title = it.label,
                            onSelectChange = {
                                onChipItemChanged(it.label)
                            },
                            isSelected = selectedItem == it.label,
                        )
                    }

                }

                Text(
                    text = "Popular Foods",
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = SidePadding),
                    fontFamily = POPPINS,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )



                LazyRow(
                    content = {

                        items(foodItems?.data?.hints ?: listOf()) { foodItem ->
                            foodItem.food.image?.let {
                                FoodCardVertical(
                                    image = foodItem.food.image,
                                    title = foodItem.food.label,
                                    subtitle = foodItem.food.category,
                                    isFavourite = false,
                                    onClick = {
                                        /*TODO*/
                                    },
                                    onFavouriteClicked = {

                                    },
                                    bottomText = "${foodItem.food.nutrients.ENERC_KCAL.toInt()} KCAL"
                                )
                            }
                        }

                        items(3) {
                            Shimmer(
                                modifier = Modifier
                                    .height(382.dp)
                                    .width(200.dp),
                                isVisible = foodItems?.status == Status.LOADING
                            )
                        }

                    },
                    contentPadding = PaddingValues(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),

                    )


            }
        }


        item {
            Text(
                text = "Recipes",
                color = Color.Black,
                modifier = Modifier.padding(horizontal = SidePadding),
                fontFamily = POPPINS,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        item {
            Shimmer(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(horizontal = SidePadding),
                isVisible = recipes?.status == Status.LOADING
            )
        }
        items(recipes?.data?.hits ?: listOf()) { recipe ->
            BottomHomeItems(Modifier.padding(horizontal = SidePadding)) {
                FoodCardHorizontal(
                    image = rememberImagePainter(data = recipe.recipe.image),
                    title = recipe.recipe.label,
                    subtitle = recipe.recipe.source,
                    isFavourite = false,
                    onClick ={

                    },
                    onFavouriteClicked = {

                    },
                    bottomText = "${recipe.recipe.totalNutrients.ENERC_KCAL?.quantity?.toInt()} KCAL"
                )
            }
        }



    }
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview
@Composable
fun HomePreview() {

    HomeScreen(
        foodItems = Resource(Status.IDLE, null, null),
        onChipItemChanged = {},
        selectedItem = "Pasta",
        recipes = null,
        onDrawerClicked = {}
    )
}