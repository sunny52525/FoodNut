package com.shaun.foodnut.models.nutrients

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TotalNutrients(
    val ENERC_KCAL: NutrientDetail?,
    val FAT: NutrientDetail?,
    val FASAT: NutrientDetail?,
    val FAMS: NutrientDetail?,
    val FAPU: NutrientDetail?,
    val CHOCDF: NutrientDetail?,
    val FIBTG: NutrientDetail?,
    val SUGAR: NutrientDetail?,
    val PROCNT: NutrientDetail?,
    val NA: NutrientDetail?,
    val CA: NutrientDetail?,
    val MG: NutrientDetail?,
    val K: NutrientDetail?,
    val FE: NutrientDetail?,
    val ZN: NutrientDetail?,
    val P: NutrientDetail?,
    val VITA_RAE: NutrientDetail?,
    val VITC: NutrientDetail?,
    val THIA: NutrientDetail?,
    val RIBF: NutrientDetail?,
    val NIA: NutrientDetail?,
    val VITB6A: NutrientDetail?,
    val FOLDFE: NutrientDetail?,
    val FOLFD: NutrientDetail?,
    val TOCPHA: NutrientDetail?,
    val VITK1: NutrientDetail?,
    val WATER: NutrientDetail?,


    ) : Parcelable