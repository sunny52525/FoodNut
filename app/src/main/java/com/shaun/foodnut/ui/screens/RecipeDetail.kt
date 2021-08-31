package com.shaun.foodnut.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.East
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.shaun.foodnut.models.recipes.RecipeObject
import com.shaun.foodnut.ui.components.*
import com.shaun.foodnut.ui.theme.Dimens.grid_0_25
import com.shaun.foodnut.ui.theme.Dimens.grid_1
import com.shaun.foodnut.ui.theme.Dimens.grid_1_25
import com.shaun.foodnut.ui.theme.Dimens.grid_2
import com.shaun.foodnut.ui.theme.Dimens.grid_3
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.ui.theme.POPPINS
import kotlin.math.roundToInt


@ExperimentalCoilApi
@Composable
fun RecipeDetailScreen(recipe: RecipeObject) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FoodNutColors.Background)
            .verticalScroll(rememberScrollState()),
    ) {
        CustomizedTopBar(
            leftIcon = Icons.Filled.ArrowBackIosNew,
            rightIcon = Icons.Filled.Favorite,
            leftClick = { /*TODO*/ }) {
        }

        Text(
            text = recipe.label,
            color = Color.Black,
            fontSize = 25.sp,
            fontFamily = POPPINS,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = grid_1, start = grid_2)
        )
        Text(
            text = recipe.healthLabels.joinToString(
                separator = ",",
                limit = 3,

                ) {
                it
            },
            color = Color.Gray,
            fontSize = 15.sp,
            fontFamily = POPPINS,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(vertical = grid_0_25, horizontal = grid_2),
            fontStyle = FontStyle.Italic
        )
        Text(
            text = recipe.mealType.joinToString(separator = ",", limit = 2) { it },
            color = Color.Gray,
            fontSize = 15.sp,
            fontFamily = POPPINS,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(vertical = grid_0_25, horizontal = grid_2),
            fontStyle = FontStyle.Italic
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = grid_2)
        ) {
            Column(Modifier.weight(1f)) {
                Header(text = "Nutrition", padding = 0.dp)


                NutritionCountCard(
                    name = "Calories",
                    weight = recipe.calories.roundToInt().toString(),
                    unit = ""
                )
                Spacer(modifier = Modifier.height(grid_1_25))
                NutritionCountCard(
                    name = recipe.totalNutrients.ENERC_KCAL?.label.toString(),
                    weight = recipe.totalNutrients.ENERC_KCAL?.quantity?.roundToInt().toString(),
                    unit = recipe.totalNutrients.ENERC_KCAL?.unit.toString()
                )
                Spacer(modifier = Modifier.height(grid_1_25))
                NutritionCountCard(
                    name = recipe.totalNutrients.FAT?.label.toString(),
                    weight = recipe.totalNutrients.FAT?.quantity?.roundToInt().toString(),
                    unit = recipe.totalNutrients.FAT?.unit.toString()
                )

            }
            Column(Modifier.weight(1f)) {
                Image(
                    painter = rememberImagePainter(data = ""),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }



        Container(Modifier.padding(top = grid_2)) {
            Header(text = "Ingredients", padding = grid_2)
            LazyRow(
                Modifier.fillMaxWidth(), contentPadding = PaddingValues(start = grid_2),
                horizontalArrangement = Arrangement.spacedBy(grid_1_25)
            ) {
                recipe.ingredients?.forEachIndexed { index, ingredient ->
                    item {
                        Log.d(
                            "Ingredient",
                            "RecipeDetailScreen: $ingredient"
                        )
                        IngredientCard(
                            imageVector = rememberImagePainter(ingredient.image),
                            title = ingredient.foodCategory,
                            weight = "${ingredient.weight.roundToInt()} ${ingredient.measure}"
                        )
                    }
                }
            }

        }

        Spacer(modifier = Modifier.height(grid_3))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "View Complete Nutrition Details",
                fontFamily = POPPINS,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(grid_2))
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.East, contentDescription = "")
            }
        }


    }
}

