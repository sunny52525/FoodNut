package com.shaun.foodnut.ui.screens

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceEvenly
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.shaun.foodnut.models.nutrients.TotalNutrients
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
import com.shaun.foodnut.utils.Extensions.Companion.noRippleClickable
import com.shaun.foodnut.utils.Extensions.Companion.toPairArray
import kotlin.math.roundToInt


@ExperimentalAnimationApi
@ExperimentalCoilApi
@Composable
fun RecipeDetailScreen(
    recipe: RecipeObject,
    onFavouriteClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    var ingredientInDialog: IngredientObject? by remember {
        mutableStateOf(null)
    }
    var dialogShown by remember {
        mutableStateOf(false)
    }

    if(dialogShown) {
        IngredientDialog(ingredient = ingredientInDialog) {
            dialogShown = dialogShown.not()
        }
    }


    var fullHealthLabelShown by remember {
        mutableStateOf(false)
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
            leftClick = onBackClicked, rightClick = onFavouriteClicked
        )

        Text(
            text = recipe.label,
            color = Color.Black,
            fontSize = 25.sp,
            fontFamily = POPPINS,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = grid_1, start = grid_2)
        )
        Text(
            text = buildAnnotatedString {
                append(
                    recipe.healthLabels
                        .joinToString(
                            separator = ",",
                            limit = if (fullHealthLabelShown) -1 else 3,
                        ) {
                            it
                        })
                if (fullHealthLabelShown.not()) {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("view more")
                    }
                }
            },
            color = Color.Gray,
            fontSize = 15.sp,
            fontFamily = POPPINS,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(vertical = grid_0_25, horizontal = grid_2)
                .animateContentSize()
                .noRippleClickable {
                    fullHealthLabelShown = fullHealthLabelShown.not()
                },
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

            BoxWithConstraints(
                Modifier
                    .fillMaxSize()
                    .padding(end = grid_1_25), contentAlignment = CenterEnd
            ) {
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

        ColumnWrapper(modifier = Modifier.padding(grid_1)) {

            DetailsNutrientView(title = "Total Nutrients", recipe.totalNutrients)
            recipe.totalDaily?.let {

                DetailsNutrientView(title = "Total Daily", recipe.totalDaily)
            }
        }
    }
}

@Composable
fun DetailsNutrientView(title: String, recipe: TotalNutrients) {
    Header(text = title)
    recipe.toArray().toPairArray {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = SpaceEvenly) {
            ColumnWrapper(Modifier.weight(1f)) {
                NutritionCountCard(
                    name = it.first?.label.toString(),
                    weight = it.first?.quantity?.roundToInt().toString(),
                    unit = it.first?.unit.toString()
                )
            }
            if (it.second != null) {
                ColumnWrapper(Modifier.weight(1f)) {
                    NutritionCountCard(
                        name = it.second?.label.toString(),
                        weight = it.second?.quantity?.roundToInt().toString(),
                        unit = it.second?.unit.toString()
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(grid_1))

    }
}

