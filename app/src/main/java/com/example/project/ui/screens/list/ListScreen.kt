package com.example.project.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.project.ui.viewmodel.SharedViewModel
import com.example.project.util.SearchAppBarState
import com.example.project.R
import com.example.project.ui.theme.fabBackgroundColor
import com.example.project.ui.theme.topAppBarBackgroundColor


@ExperimentalMaterialApi
@Composable
fun ListScreen(
    sharedViewModel: SharedViewModel,
    navigateToProfileScreen: (profileId: Int) -> Unit
) {
    LaunchedEffect(key1 = true) {
        sharedViewModel.getAllFoods()
    }

    val allFoods by sharedViewModel.allFoods.collectAsState()

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
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToProfileScreen)
        },
        content = {
            ListContent(
                foods = allFoods,
                navigateToProfileScreen = navigateToProfileScreen
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun ListFab(
    onFabClicked: (profileId: Int) -> Unit
)
{
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button ),
            tint = Color.White
        )
    }
}