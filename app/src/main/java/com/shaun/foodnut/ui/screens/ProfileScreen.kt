package com.shaun.foodnut.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaun.foodnut.ui.components.Header
import com.shaun.foodnut.ui.components.ProfileCard
import com.shaun.foodnut.ui.components.ProfileHeader
import com.shaun.foodnut.ui.theme.Dimens
import com.shaun.foodnut.ui.theme.Dimens.grid_1_25
import com.shaun.foodnut.ui.theme.Dimens.grid_2
import com.shaun.foodnut.ui.theme.FoodNutColors

@ExperimentalMaterialApi
@Composable
@Preview
fun ProfileScreen() {
    Column(
        Modifier
            .fillMaxSize(
            )

            .background(FoodNutColors.Background)
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 40.dp, start = grid_2, end = Dimens.grid_2, bottom = Dimens.grid_1)) {

            Header(text = "Profile")
            Spacer(modifier = Modifier.height(grid_1_25))
            ProfileHeader()
            Spacer(modifier = Modifier.height(grid_1_25))
            ProfileCard()
        }
    }
}