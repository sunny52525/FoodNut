package com.shaun.foodnut.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shaun.foodnut.ui.components.FoodNutDropDown
import com.shaun.foodnut.ui.components.SearchBar
import com.shaun.foodnut.ui.components.SearchScreenMoreFilters
import com.shaun.foodnut.ui.components.SearchScreenTopArea
import com.shaun.foodnut.ui.theme.Dimens.grid_1
import com.shaun.foodnut.ui.theme.Dimens.grid_2
import com.shaun.foodnut.ui.theme.Dimens.grid_3
import com.shaun.foodnut.ui.theme.FoodNutColors
import com.shaun.foodnut.utils.Constants
import com.shaun.foodnut.viewmodels.SearchViewModel

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun SearchScreen(modifier: Modifier = Modifier, viewModel: SearchViewModel) {

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
            FoodNutDropDown(
                modifier = Modifier.weight(0.5f),
                showType = false,
                dropdownContent = Constants.category
            )
        }
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SearchScreenTopArea()
            SearchScreenMoreFilters()
        }
    }
}
