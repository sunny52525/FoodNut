package com.shaun.foodnut.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.shaun.foodnut.R
import com.shaun.foodnut.models.ChipsItem
import com.shaun.foodnut.models.IconAndLabel

object Constants {
    val HEALTH_LABELS = listOf(
        "alcohol-free",
        "celery-free",
        "crustacean-free",
        "dairy-free",
        "egg-free",
        "fish-free",
        "fodmap-free",
        "gluten-free",
        "immuno-supportive",
        "keto-friendly",
        "kidney-friendly",
        "kosher",
        "low-fat-abs",
        "low-potassium",
        "low-sugar",
        "lupine-free",
        "Mediterranean",
        "mustard-free",
        "no-oil-added",
        "paleo",
        "peanut-free",
        "pescatarian",
        "pork-free",
        "red-meat-free",
        "sesame-free",
        "shellfish-free",
        "soy-free",
        "sugar-conscious",
        "tree-nut-free",
        "vegan",
        "vegetarian",
        "wheat-free",
    )

    val FOOD_CATEGORIES = listOf(
        "generic-foods",
        "generic-meals",
        "packaged-foods",
        "fast-foods"
    )

    val NUTRIENT_TYPES = listOf(
        "nutrients[CA]",
        "nutrients[CHOCDF]",
        "nutrients[CHOLE]",
        "nutrients[FAMS]",
        "nutrients[FAPU]",
        "nutrients[FASAT]",
        "nutrients[FAT]",
        "nutrients[FATRN]",
        "nutrients[FE]",
        "nutrients[FIBTG]",
        "nutrients[FOLDFE]",
        "nutrients[K]",
        "nutrients[MG]",
        "nutrients[NA]",
        "nutrients[ENERC_KCAL]",
        "nutrients[NIA]",
        "nutrients[P]",
        "nutrients[PROCNT]",
        "nutrients[RIBF]",
        "nutrients[SUGAR]",
        "nutrients[THIA]",
        "nutrients[TOCPHA]",
        "nutrients[VITA_RAE]",
        "nutrients[VITB12]",
        "nutrients[VITB6A]",
        "nutrients[VITC]",
        "nutrients[VITD]",
        "nutrients[VITK1]",
    )

    val DIET = listOf(
        "balanced",
        "high-fiber",
        "high-protein",
        "low-carb",
        "low-fat",
        "low-sodium",
    )

    val CUISINE_TYPE = listOf(
        "American",
        "Asian",
        "British",
        "Caribbean",
        "Central Europe",
        "Chinese",
        "Eastern Europe",
        "French",
        "Indian",
        "Italian",
        "Japanese",
        "Kosher",
        "Mediterranean",
        "Mexican",
        "Middle Eastern",
        "Nordic",
        "South American",
        "South East Asian"
    )

    val MEAL_TYPE = listOf(
        "Breakfast",
        "Dinner",
        "Lunch",
        "Snack",
        "Teatime",
    )

    val DISH_TYPE = listOf(
        "Biscuits and cookies",
        "Bread",
        "Cereals",
        "Condiments and sauces",
        "Desserts",
        "Drinks",
        "Main course",
        "Pancake",
        "Preps",
        "Preserve",
        "Salad",
        "Sandwiches",
        "Side dish",
        "Soup",
        "Starter",
        "Sweets",
    )

    val IMAGE_SIZE = listOf(
        "LARGE",
        "REGULAR",
        "SMALL",
        "THUMBNAIL"
    )

    const val DUMMY_IMAGE =
        "https://image.shutterstock.com/image-photo/bowl-buddha-buckwheat-pumpkin-chicken-260nw-1259570605.jpg"

    val CHIPS = listOf(
        ChipsItem(
            label = "Broccoli",
            icon = R.drawable.ic_broccoli
        ),
        ChipsItem(
            label = "Chicken",
            icon = R.drawable.ic_chicken
        ),
        ChipsItem(
            label = "IceCream",
            icon = R.drawable.ic_icecream
        ),
        ChipsItem(
            label = "Pasta",
            icon = R.drawable.ic_pasta
        ),
        ChipsItem(
            label = "Egg",
            icon = R.drawable.ic_egg
        ),
        ChipsItem(
            label = "Bread",
            icon = R.drawable.ic_bread
        )
    )

    val DRAWER_ITEMS = listOf(
        IconAndLabel(
            label = "Home",
            icon = Icons.Filled.Home
        ),
        IconAndLabel(
            label = "Favourites",
            icon = Icons.Filled.Favorite
        ),
        IconAndLabel(
            label = "Search",
            icon = Icons.Filled.Search
        ),
        IconAndLabel(
            label = "Add Recipe",
            icon = Icons.Filled.Add
        ),
        IconAndLabel(
            label = "Recipe Community",
            icon = Icons.Filled.People
        ),
        IconAndLabel(
            label = "Profile",
            icon = Icons.Filled.AccountCircle
        ),
        IconAndLabel(
            label = "Settings",
            icon = Icons.Filled.Settings
        )
    )

    val ProfileItems = listOf(
        IconAndLabel(
            label = "Edit profile",
            icon = Icons.Filled.Edit
        ),
        IconAndLabel(
            label = "Change Password",
            icon = Icons.Filled.Password
        ),
        IconAndLabel(
            label = "Block List",
            icon = Icons.Filled.Block
        ),
        IconAndLabel(
            label = "Feedback",
            icon = Icons.Filled.Feedback
        ),
        IconAndLabel(
            label = "Favourites",
            icon = Icons.Filled.Favorite
        ),
        IconAndLabel(
            label = "Logout",
            icon = Icons.Filled.Logout
        )

    )

    val category = listOf("Recipe", "Food", "Nutrients")
}