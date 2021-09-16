package com.shaun.foodnut.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.East
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.shaun.foodnut.models.recipes.IngredientObject
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
    var ingredientInDialog: IngredientObject? by remember {
        mutableStateOf(null)
    }
    var dialogShown by remember {
        mutableStateOf(false)
    }
    if (dialogShown) {
        IngredientDialog(ingredient = ingredientInDialog) {
            dialogShown = dialogShown.not()
        }
    }
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
                .height(
                    300.dp
                )
        ) {

            Column {
                NutritionDetail(recipe)
            }

            Spacer(modifier = Modifier.width(grid_1))

            BoxWithConstraints(Modifier.fillMaxSize().padding(end = grid_1_25), contentAlignment = CenterEnd) {
                val width = maxWidth
                Card(
                    shape = CircleShape, modifier = Modifier
                        .size(width)
                ) {
                    Image(
                        painter = rememberImagePainter(data = recipe.image),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }


        }




        Container(Modifier.padding(top = grid_2)) {
            Header(text = "Ingredients", padding = grid_2)
            LazyRow(
                Modifier.fillMaxWidth(), contentPadding = PaddingValues(start = grid_2),
                horizontalArrangement = Arrangement.spacedBy(grid_1_25)
            ) {
                recipe.ingredients?.forEachIndexed { _, ingredient ->
                    item {
                        Log.d(
                            "Ingredient",
                            "RecipeDetailScreen: $ingredient"
                        )
                        IngredientCard(
                            imageVector = rememberImagePainter(ingredient.image),
                            title = ingredient.food.toString(),
                            weight = "${ingredient.weight.roundToInt()} ${ingredient.measure}",
                            onClick = {
                                ingredientInDialog = ingredient
                                dialogShown = true
                                Log.d("Recipe Object", "RecipeDetailScreen: $ingredientInDialog ")
                            }
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

