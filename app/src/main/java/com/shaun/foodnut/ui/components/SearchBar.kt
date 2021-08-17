package com.shaun.foodnut.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaun.foodnut.ui.theme.POPPINS

@ExperimentalMaterialApi
@Composable
fun SearchPlaceholder(placeholder: String, onClick: () -> Unit) {

    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        shape = RoundedCornerShape(15.dp),
        backgroundColor = Color.White
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.DarkGray
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = placeholder, color = Color.DarkGray, fontFamily = POPPINS)
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun SearchPlaceholderPreview() {

    SearchPlaceholder(placeholder = "Find recipes or chef") {

    }
}

