package com.example.project.navigation.destination

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.project.ui.screens.list.ListScreen
import com.example.project.ui.viewmodel.SharedViewModel
import com.example.project.util.Constants.LIST_ARGUMENT_KEY
import com.example.project.util.Constants.LIST_SCREEN

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToProfileScreen: (profileId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        }
        )
    ) {
        ListScreen(
            navigateToProfileScreen = navigateToProfileScreen,
            sharedViewModel = sharedViewModel
        )
    }
}