package com.shaun.foodnut.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaun.foodnut.R
import com.shaun.foodnut.ui.theme.Dimens.SidePadding
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.ui.theme.POPPINS
import com.shaun.foodnut.utils.Extensions.Companion.noRippleClickable

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
fun IngredientCard(imageVector: Painter?, title: String, weight: String) {

    Column(Modifier.width(100.dp)) {

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
@Preview
fun IngredientPreview() {
    IngredientCard(imageVector = null, title = "Avocado", weight = "250gm")
}

