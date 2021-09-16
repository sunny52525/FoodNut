package com.shaun.foodnut.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.shaun.foodnut.R
import com.shaun.foodnut.models.recipes.IngredientObject
import com.shaun.foodnut.models.recipes.RecipeObject
import com.shaun.foodnut.ui.theme.Dimens.SidePadding
import com.shaun.foodnut.ui.theme.Dimens.grid_0_5
import com.shaun.foodnut.ui.theme.Dimens.grid_1
import com.shaun.foodnut.ui.theme.Dimens.grid_1_25
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.ui.theme.FoodNutColors.Green
import com.shaun.foodnut.ui.theme.POPPINS
import com.shaun.foodnut.utils.Extensions.Companion.noRippleClickable
import kotlin.math.roundToInt

@Composable
fun CustomizedTopBar(
    leftIcon: ImageVector,
    rightIcon: ImageVector,
    leftClick: () -> Unit,
    rightClick: () -> Unit,
) {

    TopAppBar(
        title = {
        },
        navigationIcon = {
            Icon(
                imageVector = leftIcon,
                contentDescription = "Menu",

                modifier = Modifier
                    .noRippleClickable(leftClick)
                    .padding(horizontal = SidePadding),
                tint = Color.Black
            )
        },
        backgroundColor = FoodNutColors.Background,
        actions = {
            Icon(
                imageVector = rightIcon,
                contentDescription = "Menu",
                modifier = Modifier
                    .noRippleClickable(rightClick)

                    .padding(horizontal = SidePadding),
                tint = Color.Black
            )
        },
        elevation = 0.dp
//        modifier = Modifier

    )
}

@Composable
@Preview
fun TopbarPreview() {
    CustomizedTopBar(
        leftIcon = Icons.Filled.Sort,
        rightIcon = Icons.Filled.Favorite,
        leftClick = { /*TODO*/ }) {

    }
}

@Composable
@Preview
fun CalorieCard(title: String = "250") {
    Card(backgroundColor = Color.White, elevation = 10.dp, shape = CircleShape) {
        Text(
            text = title,
            color = Color.Black,
            modifier = Modifier.padding(10.dp),
            fontFamily = POPPINS,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview
fun NutritionCountCard(name: String = "Calories", weight: String = "250", unit: String = "KCAL") {
    Card(
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
    ) {

        Row(Modifier.padding(vertical = 10.dp, horizontal = 15.dp)) {
            CalorieCard(weight)

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(text = name, color = Color.Black, fontFamily = POPPINS)
                Text(text = unit, color = Color.Gray, fontFamily = POPPINS)
            }
        }

    }
}


@Composable
fun IngredientCard(imageVector: Painter?, title: String, weight: String, onClick: () -> Unit) {

    Column(
        Modifier
            .width(100.dp)
            .noRippleClickable { onClick() }) {

        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            backgroundColor = Color.Gray
        ) {
            Image(
                painter = imageVector ?: painterResource(id = R.drawable.food_dummy),
                contentDescription = "food",
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = title,
            color = Color.Black,
            fontFamily = POPPINS,
            fontWeight = FontWeight.SemiBold
        )
        Text(text = weight, color = Color.Gray, fontFamily = POPPINS)

    }
}

@Composable
fun NutritionDetail(recipe: RecipeObject) {

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

@Composable
@Preview
fun IngredientPreview() {
    IngredientCard(imageVector = null, title = "Avocado", weight = "250gm"){}
}

/**
 * val text: String,
val weight: Float,
val foodCategory: String,
val foodId: String,
val image: String,
val food: String?,
val quantity: String?,
@SerializedName("measure")
val measure: String?,
 */
@ExperimentalCoilApi
@Composable
fun IngredientDialog(ingredient: IngredientObject?, onDialogClose: () -> Unit) {

    ingredient?.let {
        Dialog(onDismissRequest = onDialogClose) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "",
                    modifier = Modifier
                        .noRippleClickable(onDialogClose)
                        .align(Alignment.TopEnd)
                        .background(Green)
                        .zIndex(5f)
                        .padding(grid_1),
                    tint = Color.White,

                    )
                Column(
                    modifier = Modifier
                        .padding(grid_1_25)
                        .fillMaxWidth()
                        .border(1.dp, color = FoodNutColors.Green)
                        .padding(grid_0_5),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = ingredient.food.toString(),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = POPPINS,
                    )

                    Image(
                        painter = if (ingredient.image != null) rememberImagePainter(ingredient.image) else painterResource(
                            id = R.drawable.food_dummy
                        ),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .fillMaxHeight(0.6f),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "${ingredient.quantity} ${ingredient.measure}, ${ingredient.weight}grams",
                        color = Color.Gray,
                        textAlign = TextAlign.Center,

                        )
                    Text(
                        text = ingredient.text,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,

                        )


                }
            }

        }

    }

}


@ExperimentalCoilApi
@Preview
@Composable
fun IngredientDialogPreview() {
    IngredientDialog(
        ingredient = IngredientObject(
            text = "2 tablespoons of grated Pecorino Romano",
            weight = 16.4999999721034f,
            foodCategory = "Cheese",
            foodId = "food_bmxguz9abbdnfvbuklp2mbsrpt6b",
            image = null,
            quantity = 2,
            measure = "ounce",
            food = "Pasta"
        )
    ) {

    }
}

