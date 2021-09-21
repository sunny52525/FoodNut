package com.shaun.foodnut.utils

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

class Extensions {
    companion object {
        inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier =
            composed{
                clickable(indication = null,
                    interactionSource = remember { MutableInteractionSource() }) {
                    onClick()
                }
            }


        fun Activity.showToast(message: String?) {
            Toast.makeText(this.applicationContext, message, Toast.LENGTH_SHORT).show()
        }

        inline fun <T> ArrayList<T>.toPairArray(action: (Pair<T, T?>) -> Unit): Unit {
            for (element in 0 until this.size step 2) {
                if (element + 1 == this.size) {
                    action(Pair(this[element], null))
                } else
                    action(Pair(this[element], this[element + 1]))
            }
        }

    }
}