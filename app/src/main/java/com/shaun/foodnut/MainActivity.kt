package com.shaun.foodnut

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.shaun.foodnut.ui.theme.FoodnutTheme
import com.shaun.foodnut.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        val viewmodel: HomeViewModel by viewModels()

        viewmodel.key.observe(this, {
            Log.d(TAG, "onCreate: $it")
        })
        setContent {
            FoodnutTheme {

                Box(
                    contentAlignment = Alignment.Center

                ) {
                    Text(text = "Hello World", color = Black)

                }

            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }


}