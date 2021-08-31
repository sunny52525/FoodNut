package com.shaun.foodnut.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaun.foodnut.ui.theme.Dimens
import com.shaun.foodnut.ui.theme.Dimens.grid_2
import com.shaun.foodnut.ui.theme.POPPINS
import retrofit2.http.Header

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

@Composable
fun Header(text:String,color: Color= Color.Black,padding:Dp=grid_2) {
    Text(
        text = text,
        color = color,
        fontSize = 25.sp,
        fontFamily = POPPINS,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(top = Dimens.grid_1, start = padding)
    )
}