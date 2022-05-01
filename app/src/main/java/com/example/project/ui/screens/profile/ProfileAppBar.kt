package com.example.project.ui.screens.profile

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.project.ui.theme.topAppBarBackgroundColor
import com.example.project.ui.theme.topAppBarContentColor
import com.example.project.util.Action
import com.example.project.R
import com.example.project.data.model.FoodCalData

@Composable
fun ProfileAppBar(
    navigateToListScreen: (Action) -> Unit
){
    NewProfileAppBar(navigateToListScreen = navigateToListScreen)

}

@Composable
fun NewProfileAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
                         BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = stringResource(id = R.string.add_foods),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }

    )
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
){
    IconButton(
        onClick = {
            onBackClicked(Action.NO_ACTION)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_arrow),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }

}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
){
    IconButton(
        onClick = {
            onAddClicked(Action.ADD)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.add_foods_again),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }

}

@Composable
fun ExistingProfileAppBar(
    selectedFood: FoodCalData,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = selectedFood.foodName,
                color = MaterialTheme.colors.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            DeleteAction(onDeleteClicked = navigateToListScreen)
            UpdateAction(onUpdateClicked = navigateToListScreen)
        }

    )
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
){
    IconButton(
        onClick = {
            onCloseClicked(Action.NO_ACTION)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(id = R.string.close_icon),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }

}

@Composable
fun DeleteAction(
    onDeleteClicked: (Action) -> Unit
){
    IconButton(
        onClick = {
            onDeleteClicked(Action.DELETE)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(id = R.string.delete),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }

}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
){
    IconButton(
        onClick = {
            onUpdateClicked(Action.UPDATE)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.update),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }

}

@Composable
@Preview
fun NewProfileBarAppPreview(){
    NewProfileAppBar(navigateToListScreen = {})
}

@Composable
@Preview
fun ExistingProfileBarAppPreview(){
    ExistingProfileAppBar(
        selectedFood = FoodCalData(
            id = 0,
            foodName = "Banana",
            calories = "25",
            carbs = "81"
        ),
        navigateToListScreen = {})
}