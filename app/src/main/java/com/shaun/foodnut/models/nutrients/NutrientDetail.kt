package com.shaun.foodnut.models.nutrients

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NutrientDetail(
    val label: String?,
    val quantity: Double?,
    val unit: String?,
) : Parcelable {

}