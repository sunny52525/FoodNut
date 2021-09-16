package com.shaun.foodnut.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.shaun.foodnut.R
import com.shaun.foodnut.ui.theme.Dimens.grid_0_5
import com.shaun.foodnut.ui.theme.Dimens.grid_1
import com.shaun.foodnut.ui.theme.Dimens.grid_1_25
import com.shaun.foodnut.ui.theme.FoodNutColors.Green
import com.shaun.foodnut.ui.theme.POPPINS
import com.shaun.foodnut.utils.Constants

@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    placeholder: String = "Search Recipes,Food,Nutrition"
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = modifier,
        value = query,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontFamily = POPPINS,
            fontSynthesis = FontSynthesis.Style
        ),
        placeholder = {
            Text(text = placeholder)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search, contentDescription = "",
                tint = Green
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch()
                keyboardController?.hide()

            }
        ),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Green.copy(alpha = 0.5f),
            textColor = Green
        )

    )
}


@Preview(showBackground = true)
@Composable
fun FoodNutDropDown(
    modifier: Modifier = Modifier,
    title: String = "Type",
    dropdownContent: List<String> = Constants.DIET,
    placeholder: String = "Diet",
    showType: Boolean = true,
    onclick: (String) -> Unit = {}
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val checked: MutableList<Boolean> by remember {
        mutableStateOf(MutableList(dropdownContent.size) {
            false
        })
    }

    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180F else 0F,
        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ),
        finishedListener = {

        }
    )
    Column(modifier.fillMaxWidth()) {

        if (showType)
            Text(
                text = title,
                color = Green,
                fontSize = 18.sp,
                fontFamily = POPPINS,
                modifier = Modifier
                    .padding(start = 10.dp)
            )

        Column(
            Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }

        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .border(
                        if (expanded) 1.5.dp else 1.dp,
                        if (expanded) Green else Green.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(10.dp)
                    .height(30.dp)
            ) {
                Text(
                    text = placeholder,
                    color = Green,
                    fontFamily = POPPINS,
                    modifier = Modifier
                        .alpha(0.8f)
                        .align(Alignment.CenterStart)
                )
                Icon(
                    imageVector =
                    Icons.Filled.ExpandMore,
                    contentDescription = "",
                    modifier = Modifier
                        .rotate(angle)
                        .align(
                            Alignment.CenterEnd
                        ),
                    tint = Green
                )
            }


            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        Green
                    )
                    .padding(10.dp)
            ) {


                dropdownContent.forEachIndexed { index, label ->
                    var ch by remember {
                        mutableStateOf(checked[index])
                    }

                    DropdownMenuItem(onClick = {
                        onclick(label)
                        ch = ch.not()
                        checked[index] = checked[index].not()
                    }) {


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Checkbox(
                                checked = ch,
                                onCheckedChange = {
                                    ch = it
                                    checked[index] = it
                                },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color.White,
                                    checkmarkColor = Green,
                                    uncheckedColor = Color.White

                                    ),

                                )

                            Text(
                                text = label,
                                modifier = Modifier.padding(start = grid_1),
                                color = Color.White
                            )
                        }
                    }
                }
            }


        }

        Spacer(modifier = Modifier.height(25.dp))


    }

}


@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
@Preview
fun RangeSelector() {
    /**
     * range/more_than
     */
    var selectedType by remember {
        mutableStateOf("range")
    }

    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(grid_0_5)
        ) {

            Spacer(modifier = Modifier.width(10.dp))

            SelectableChips(
                icon = painterResource(id = R.drawable.ic_width),
                title = "Range",
                onSelectChange = {
                    selectedType = "range"
                },
                isSelected = selectedType == "range",
                modifier = Modifier
                    .fillMaxWidth(0.25f) ,
                showIcon = false
            )
            Spacer(modifier = Modifier.width(10.dp))
            SelectableChips(
                icon = painterResource(id = R.drawable.ic_more_than),
                title = "More than",
                onSelectChange = {
                    selectedType = "more_than"
                },
                isSelected = selectedType == "more_than",
                modifier = Modifier.fillMaxWidth(5f),
                showIcon = false

            )
        }

        Spacer(modifier = Modifier.height(grid_1_25))

        AnimatedVisibility(visible = selectedType == "range") {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                TextField(
                    value = "1",
                    onValueChange = {},
                    modifier = Modifier.weight(1f),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = Color.White,
                        unfocusedBorderColor = Green,
                        focusedBorderColor = Green
                    )
                )
                Icon(
                    imageVector = Icons.Filled.Minimize,
                    contentDescription = "",
                    modifier = Modifier.padding(
                        grid_0_5
                    )
                )
                TextField(
                    value = "2", onValueChange = {}, modifier = Modifier.weight(1f),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = Color.White,
                        unfocusedBorderColor = Green,
                        focusedBorderColor = Green
                    )
                )
            }
        }
        AnimatedVisibility(visible = selectedType == "more_than") {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextField(
                    value = "1", onValueChange = {},
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = Color.White,
                        unfocusedBorderColor = Green,
                        focusedBorderColor = Green
                    )
                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    modifier = Modifier.padding(
                        grid_0_5
                    )
                )
            }
        }


    }

}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun SearchScreenTopArea() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        FoodNutDropDown(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            title = "Diet",
            dropdownContent = Constants.DIET
        )

        Spacer(modifier = Modifier.width(10.dp))

        FoodNutDropDown(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.5f),
            title = "Health",
            dropdownContent = Constants.HEALTH_LABELS,


            )
    }
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {

        FoodNutDropDown(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            title = "Cuisine Type",
            dropdownContent = Constants.CUISINE_TYPE
        )

        Spacer(modifier = Modifier.width(10.dp))

        FoodNutDropDown(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.5f),
            title = "Meal Type",
            dropdownContent = Constants.MEAL_TYPE,

            )
    }

    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

        FoodNutDropDown(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            title = "Dish Type",
            dropdownContent = Constants.DISH_TYPE
        )

        Spacer(modifier = Modifier.width(10.dp))

    }


}


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun SearchScreenMoreFilters() {

    Card(
        shape = RoundedCornerShape(15.dp),
        backgroundColor = Color.White,
        modifier = Modifier


    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .padding(grid_1)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Add more filters",
                    modifier = Modifier.align(Alignment.CenterStart),
                    fontFamily = POPPINS,
                    fontWeight = FontWeight.SemiBold
                )

            }

            Column(Modifier.fillMaxWidth()) {

                repeat(29) {
                    RangeSelector()
                    Spacer(modifier = Modifier.height(grid_0_5))
                }

            }

        }
    }
}


@Composable
fun FillingInfo() {
    Dialog(onDismissRequest = { /*TODO*/ }) {

    }
}