package com.shaun.foodnut.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaun.foodnut.ui.components.FoodNutDropDown
import com.shaun.foodnut.ui.components.SearchBar
import com.shaun.foodnut.ui.theme.Dimens.grid_1
import com.shaun.foodnut.ui.theme.Dimens.grid_2
import com.shaun.foodnut.ui.theme.Dimens.grid_3
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.ui.theme.POPPINS
import com.shaun.foodnut.utils.Extensions.Companion.noRippleClickable

// TODO: 9/5/2021 Refactor this
@ExperimentalComposeUiApi
@Preview
@Composable
fun SearchScreen(modifier: Modifier = Modifier) {

    var show by remember {
        mutableStateOf(false)
    }
    val angle: Float by animateFloatAsState(
        targetValue = if (show) 180F else 0F,
        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ),
        finishedListener = {

        }
    )
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
                query = "Search",
                onValueChange = {},
                onSearch = { /*TODO*/ },
                modifier = Modifier.weight(
                    1.5f
                )
            )
            Spacer(modifier = Modifier.width(10.dp))
            FoodNutDropDown(modifier = Modifier.weight(0.5f), showType = false)
        }
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            content = {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    FoodNutDropDown(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    FoodNutDropDown(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(0.5f)

                    )
                }
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {

                    FoodNutDropDown(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    FoodNutDropDown(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(0.5f)

                    )
                }

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {

                    FoodNutDropDown(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    FoodNutDropDown(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(0.5f)

                    )
                }

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    FoodNutDropDown(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    FoodNutDropDown(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(0.5f)

                    )
                }

                Card(
                    shape = RoundedCornerShape(15.dp),
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .noRippleClickable {
                            show = !show
                        }


                ) {

                    Column(
                        Modifier
                            .fillMaxWidth()
                            .animateContentSize()
                            .padding(grid_1)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(
                                text = "Add more filters",
                                modifier = Modifier.align(Alignment.CenterStart),
                                fontFamily = POPPINS,
                                fontWeight = FontWeight.SemiBold
                            )
                            Icon(
                                imageVector = Icons.Filled.ExpandMore,
                                contentDescription = "",
                                modifier = Modifier
                                    .align(
                                        Alignment.CenterEnd
                                    )
                                    .rotate(angle)

                            )
                        }
                        if (show) {
                            Column(Modifier.fillMaxWidth()) {
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f)
                                    )

                                    Spacer(modifier = Modifier.width(10.dp))

                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxWidth(0.5f)

                                    )
                                }
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f)
                                    )

                                    Spacer(modifier = Modifier.width(10.dp))

                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxWidth(0.5f)

                                    )
                                }
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f)
                                    )

                                    Spacer(modifier = Modifier.width(10.dp))

                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxWidth(0.5f)

                                    )
                                }
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f)
                                    )

                                    Spacer(modifier = Modifier.width(10.dp))

                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxWidth(0.5f)

                                    )
                                }
                                Row(
                                    Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f)
                                    )

                                    Spacer(modifier = Modifier.width(10.dp))

                                    FoodNutDropDown(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxWidth(0.5f)

                                    )
                                }


                            }

                        }
                    }
                }
            })
    }
}