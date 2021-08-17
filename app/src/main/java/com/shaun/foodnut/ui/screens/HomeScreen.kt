package com.shaun.foodnut.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.shaun.foodnut.ui.components.*
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.ui.theme.POPPINS
import com.shaun.foodnut.ui.theme.SidePadding
import com.shaun.foodnut.utils.Constants


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen() {

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(FoodNutColors.GenericBackground),
//        contentPadding = PaddingValues(SidePadding),
        verticalArrangement = Arrangement.spacedBy(10.dp),


        ) {
        item {
            CustomizedTopBar(
                leftIcon = Icons.Filled.Sort,
                rightIcon = Icons.Filled.AccountCircle,
                leftClick = {
                }, rightClick = {

                })
        }


        item {
            TopArea(modifier = Modifier.padding(horizontal = SidePadding)) {

                Greeting(time = "Good Morning", name = "Sunny")
                SearchPlaceholder(placeholder = "Search Recipes,foods,nutirents", onClick = {

                })
            }
        }

        item {
            Suggestions() {
                LazyRow(
                    Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    repeat(10) {
                        item(it) {

                            SelectableChips(
                                icon = Icons.Filled.Headphones,
                                title = "Vegetable",
                                onSelectChange = { },
                                isSelected = false,

                                )
                        }
                    }
                }
                LazyRow(
                    content = {
                        repeat(10) {
                            item(it) {
                                FoodCardVertical(
                                    image = Constants.DUMMY_IMAGE,
                                    title = "Chopped Springs",
                                    subtitle = "Onions & Fennel",
                                    isFavourite = it % 2 == 0,
                                    onClick = { /*TODO*/ }, onFavouriteClicked = {

                                    })
                            }
                        }
                    },
                    contentPadding = PaddingValues(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                )


            }
        }


        item {
            Text(
                text = "Popular Foods",
                color = Color.Black,
                modifier = Modifier.padding(horizontal = SidePadding),
                fontFamily = POPPINS,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        repeat(10) {
            item(it) {
                BottomHomeItems(Modifier.padding(horizontal = SidePadding)) {
                    FoodCardHorizontal(
                        image = rememberImagePainter(data = Constants.DUMMY_IMAGE),
                        title = "Crab Ramen",
                        subtitle = "Spicy With garlic",
                        isFavourite = it % 2 == 1,
                        onClick = { /*TODO*/ }, onFavouriteClicked = {

                        })
                }
            }
        }


    }
}