package com.shaun.foodnut.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaun.foodnut.models.IconAndLabel
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.ui.theme.POPPINS
import com.shaun.foodnut.utils.Constants

@Composable
fun Drawer(
    items: List<IconAndLabel>,
    selectedRoute: String,
    onClick: (Int) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .height(height = 30.dp)
                .background(FoodNutColors.Green)) {
        }
        items.forEachIndexed { index, item ->
            DrawerRow(
                iconAndLabel = item,
                isSelected = selectedRoute == item.label
            ) {
                onClick(index)
            }
        }
    }
}

@Composable
fun DrawerRow(

    iconAndLabel: IconAndLabel,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()

            .background(if (isSelected) FoodNutColors.Green else Color.White)
            .clickable(
                onClickLabel = iconAndLabel.label,
                onClick = onClick,
                enabled = isSelected.not()
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = iconAndLabel.icon,
            contentDescription = iconAndLabel.label,
            modifier = Modifier.padding(start = 8.dp),
            tint = if (isSelected) Color.White else Color.Black,
        )
        Text(
            text = iconAndLabel.label,
            color = if (isSelected) Color.White else Color.Black,
            modifier = Modifier.padding(
                vertical = 8.dp,
                horizontal = 16.dp
            ),
            fontFamily = POPPINS,
            fontWeight = FontWeight.SemiBold
        )

    }
}


@Preview
@Composable
fun DrawerRowPrev() {
    Drawer(
        items = Constants.DRAWER_ITEMS,
        onClick = {},
        selectedRoute = "Search"
    )
}