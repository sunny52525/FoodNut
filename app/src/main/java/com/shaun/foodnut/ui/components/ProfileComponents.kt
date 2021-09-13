package com.shaun.foodnut.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaun.foodnut.models.IconAndLabel
import com.shaun.foodnut.ui.theme.Dimens.grid_1
import com.shaun.foodnut.ui.theme.Dimens.grid_1_25
import com.shaun.foodnut.ui.theme.Dimens.grid_2
import com.shaun.foodnut.ui.theme.Dimens.grid_3
import com.shaun.foodnut.ui.theme.FoodNutColors.Green
import com.shaun.foodnut.ui.theme.POPPINS
import com.shaun.foodnut.utils.Constants

@ExperimentalMaterialApi
@Preview
@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(grid_2)
            .height(100.dp)
    ) {

        Card(
            onClick = { /*TODO*/ }, shape = RoundedCornerShape(grid_1),
            modifier = Modifier
                .weight(0.3f),
            backgroundColor = Color.LightGray
        ) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )

            }


        }
        Spacer(modifier = Modifier.width(grid_1_25))
        Column(
            modifier = Modifier
                .weight(0.7f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sunny Kumar",
                color = Color.Black,
                fontFamily = POPPINS,
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp
            )
            Text(text = "Kumarsunny3232@gmail.com", color = Color.Black.copy(alpha = 0.6f))
        }

    }
}

@Composable
fun ProfileRowItem(iconAndLabel: IconAndLabel) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, iconAndLabel.label, Toast.LENGTH_SHORT)
                    .show()
            }

    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(grid_1)
        ) {
            Icon(
                imageVector = iconAndLabel.icon,
                contentDescription = "Icon",
                tint = Green
            )
            Spacer(modifier = Modifier.width(grid_1_25))
            Text(text = iconAndLabel.label, color = Color.Black, fontFamily = POPPINS)
        }
        Icon(
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = "",
            modifier = Modifier
                .align(
                    Alignment.CenterEnd
                )
                .padding(grid_1)
        )
        Button(onClick = { /*TODO*/ }) {

        }

    }

}

@Composable
@Preview
fun ProfileCard() {
    Card(
        shape = RoundedCornerShape(grid_1_25),
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth(
            )
            .padding(grid_2)
    ) {
        Column(
            Modifier.fillMaxWidth()
        ) {
            Constants.ProfileItems.forEachIndexed { index, iconAndLabel ->
                ProfileRowItem(iconAndLabel = iconAndLabel)
                if (index != Constants.ProfileItems.lastIndex)
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = grid_3)
                    )
            }

        }
    }
}