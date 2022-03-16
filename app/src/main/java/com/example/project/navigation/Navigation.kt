package com.example.project.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.project.navigation.destination.listComposable
import com.example.project.navigation.destination.profileComposable
import com.example.project.ui.viewmodel.SharedViewModel
import com.example.project.util.Constants.LIST_SCREEN

@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController){
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToProfileScreen = screen.profile,
            sharedViewModel = sharedViewModel
        )
        profileComposable(
            navigateToListScreen = screen.list
        )
    }
}