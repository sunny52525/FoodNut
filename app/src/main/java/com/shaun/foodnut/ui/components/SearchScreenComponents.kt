package com.shaun.foodnut.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaun.foodnut.ui.theme.Dimens.grid_1
import com.shaun.foodnut.ui.theme.FoodNutColors
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
                tint = FoodNutColors.Green
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
            focusedBorderColor = FoodNutColors.Green,
            unfocusedBorderColor = FoodNutColors.Green.copy(alpha = 0.5f),
            textColor = FoodNutColors.Green
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
    var checked: MutableList<Boolean> by remember {
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
                color = FoodNutColors.Green,
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
                        if (expanded) FoodNutColors.Green else FoodNutColors.Green.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(10.dp)
                    .height(30.dp)
            ) {
                Text(
                    text = placeholder,
                    color = FoodNutColors.Green,
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
                    tint = FoodNutColors.Green
                )
            }


            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        FoodNutColors.Green
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
