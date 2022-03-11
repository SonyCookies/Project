package com.example.project.ui.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.project.R
import com.example.project.ui.theme.topAppBarBackgroundColor
import com.example.project.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(

) {
    TopBar()
}

@Composable
fun TopBar(

) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.title),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )

}

@Preview
@Composable
fun HomeTopBarPreview() {
    TopBar()
}