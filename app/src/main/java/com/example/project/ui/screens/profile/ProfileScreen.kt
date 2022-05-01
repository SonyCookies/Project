package com.example.project.ui.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.project.util.Action

@Composable
fun ProfileScreen(
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            ProfileAppBar(navigateToListScreen = navigateToListScreen)
        },
        content = {}

    )
}