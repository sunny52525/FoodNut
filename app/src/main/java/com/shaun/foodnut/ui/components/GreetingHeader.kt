package com.shaun.foodnut.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaun.foodnut.ui.theme.POPPINS

@ExperimentalMaterialApi
@Composable
fun Greeting(time: String, name: String) {

    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp), verticalAlignment = Alignment.CenterVertically
    ) {

        Column(Modifier.fillMaxWidth(0.85f)) {
            Text(text = time, color = Color.Gray, fontSize = 15.sp, fontFamily = POPPINS)
            Text(text = name, color = Color.Black, fontSize = 25.sp, fontFamily = POPPINS)
        }

    }

}

@ExperimentalMaterialApi
@Composable
@Preview
fun GreetingPreview() {
    Greeting(time = "Good Morning", name = "Sunny Kumar")
}