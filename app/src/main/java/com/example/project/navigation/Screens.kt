package com.example.project.navigation

import androidx.navigation.NavHostController
import com.example.project.util.Action
import com.example.project.util.Constants.LIST_SCREEN

class Screens(
    navController: NavHostController
) {
    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) {
                inclusive = true
            }
        }
    }

    val profile: (Int) -> Unit = { profileId ->
        navController.navigate(route = "profile/$profileId")
    }
}