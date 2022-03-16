package com.example.project.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.project.util.Action
import com.example.project.util.Constants.PROFILE_ARGUMENT_KEY
import com.example.project.util.Constants.PROFILE_SCREEN

fun NavGraphBuilder.profileComposable(
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route = PROFILE_SCREEN,
        arguments = listOf(navArgument(PROFILE_ARGUMENT_KEY){
            type = NavType.IntType
        }
        )
    ) {

    }
}