package com.shaun.foodnut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.shaun.foodnut.ui.theme.ChefbookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ChefbookTheme {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White), contentAlignment = Alignment.Center
                )
                {
                    Text(text = "Hello ", color = Color.Black)
                }

            }
        }
    }

}
