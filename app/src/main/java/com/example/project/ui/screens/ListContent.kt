package com.example.project.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.project.data.model.FoodCalData
import com.example.project.ui.theme.*


@Composable
fun ListContent(

) {

}

@ExperimentalMaterialApi
@Composable
fun ProfileItem(
    foodCalData: FoodCalData,
    navigateToProfileScreen: (profileId: Int) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.profileItemBackgroundColor,
        shape = RectangleShape,
        elevation = CATEGORY_ITEM_ELEVATION,
        onClick = {
            navigateToProfileScreen(foodCalData.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(all = LARGE_PADDING)
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth()
            ) {
                Text(
                    text = foodCalData.foodName,
                    color = MaterialTheme.colors.profileItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )

                Text(
                    text = foodCalData.calories,
                    color = MaterialTheme.colors.categoryTextColor,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ListContentPreview() {
    ProfileItem(foodCalData = FoodCalData(
        0,
        "Banana",
        "92",
        "99"
    ), navigateToProfileScreen = {})
}