package com.example.project.ui.screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.project.ui.viewmodel.SharedViewModel
import com.example.project.util.SearchAppBarState

@Composable
fun ListScreen(
    sharedViewModel: SharedViewModel,
    navigateToProfileScreen: (profileId: Int) -> Unit
) {
    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarState

    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        }
    ){

    }

}