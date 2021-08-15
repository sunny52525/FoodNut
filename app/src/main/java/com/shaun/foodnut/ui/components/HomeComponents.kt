package com.shaun.foodnut.ui.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import com.shaun.foodnut.R
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.ui.theme.POPPINS
import com.shaun.foodnut.ui.theme.SidePadding

@ExperimentalMaterialApi
@Composable
fun SelectableChips(
    icon: ImageVector, title: String,
    onSelectChange: () -> Unit,
    isSelected: Boolean,
    color: Color,
) {


    Card(
        shape = RoundedCornerShape(55), backgroundColor = color, modifier = Modifier
            .defaultMinSize(minWidth = 100.dp)
            .height(50.dp)
            .toggleable(value = isSelected, onValueChange = {
                onSelectChange()
            })
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp)
        ) {

            Icon(
                imageVector = icon,
                contentDescription = "icon",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .fillMaxHeight(),
                tint = if (isSelected) Color.White else Color.Black
            )
            Text(
                text = title,
                color = if (isSelected) Color.White else Color.Black,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )

        }
    }

}


@ExperimentalMaterialApi
@Composable
fun FoodCardVertical(
    image: ImagePainter?,
    title: String,
    subtitle: String,
    isFavourite: Boolean,
    onClick: () -> Unit,
    onFavouriteClicked: () -> Unit
) {

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(SidePadding)
                .height(350.dp)
        ) {
            Image(
                painter = image ?: painterResource(id = R.drawable.food_dummy),
                contentDescription = "food_image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))

            FoodTitleCard(title, subtitle, onFavouriteClicked, isFavourite)


        }

    }
}

@ExperimentalMaterialApi
@Composable
fun FoodCardHorizontal(
    image: ImagePainter?,
    title: String,
    subtitle: String,
    isFavourite: Boolean,
    onClick: () -> Unit,
    onFavouriteClicked: () -> Unit
) {

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(SidePadding)
        ) {
            Image(
                painter = image ?: painterResource(id = R.drawable.food_dummy),
                contentDescription = "food_image",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(0.35f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))

            FoodTitleCard(title, subtitle, onFavouriteClicked, isFavourite)


        }

    }
}

@ExperimentalMaterialApi
@Composable
private fun FoodTitleCard(
    title: String,
    subtitle: String,
    onFavouriteClicked: () -> Unit,
    isFavourite: Boolean
) {
    Column(
        Modifier
            .fillMaxHeight()
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontFamily = POPPINS,
            fontSize = 25.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = subtitle, color = Color.Gray, fontFamily = POPPINS, fontSize = 15.sp)


        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = "250 KCAL",
                color = Color.Black,
                fontFamily = POPPINS,
                fontSize = 15.sp,
                modifier = Modifier.align(
                    Alignment.BottomStart
                )
            )

            Card(
                onClick = { onFavouriteClicked() },
                backgroundColor = Color.Gray.copy(alpha = 0.4f),
                shape = CircleShape,
                modifier = Modifier
                    .align(
                        Alignment.BottomEnd
                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "",

                    modifier = Modifier.padding(10.dp),
                    tint = if (isFavourite) Color.Red else Color.White
                )

            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview

fun FoodCardPreview() {
    Column {
        FoodCardHorizontal(
            image = null,
            title = "Chopped Spring",
            subtitle = "Onion and Chips",
            onClick = { /*TODO*/ },

            isFavourite = true
        ) {

        }
        Spacer(modifier = Modifier.height(20.dp))
        FoodCardVertical(
            image = null,
            title = "Chopped Spring",
            subtitle = "Onion and Chips",
            onClick = { /*TODO*/ },

            isFavourite = true
        ) {

        }
    }
}


@ExperimentalMaterialApi
@Composable
@Preview
fun SelectableChipPreview() {
    var selected by remember { mutableStateOf(true) }
    val transition = updateTransition(selected, label = "")
    val borderColor by transition.animateColor(label = "") { isSelected ->
        if (isSelected) FoodNutColors.Green else Color.White
    }
    LazyRow(content = {
        repeat(10) {
            item(it) {
                SelectableChips(
                    icon = Icons.Filled.Favorite,
                    title = "Veg",
                    onSelectChange = {
                        selected = !selected
                    },
                    isSelected = selected,

                    color = borderColor
                )
            }
        }
    })
}