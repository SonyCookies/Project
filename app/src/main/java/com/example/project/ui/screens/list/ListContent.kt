package com.example.project.ui.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.data.model.FoodCalData
import com.example.project.ui.theme.*
import com.example.project.util.RequestState

@ExperimentalMaterialApi
@Composable
fun ListContent(
    foods: RequestState<List<FoodCalData>>,
    navigateToProfileScreen: (profileId: Int) -> Unit
) {
    if(foods is RequestState.Success) {
        if(foods.data.isEmpty()){
            EmptyContent()
        } else {
            DisplayFoods(foods = foods.data, navigateToProfileScreen = navigateToProfileScreen)
        }

    }

}

@ExperimentalMaterialApi
@Composable
fun DisplayFoods(
    foods: List<FoodCalData>,
    navigateToProfileScreen: (profileId: Int) -> Unit
) {
    LazyColumn {
        items(
            items = foods,
            key = { food ->
                food.id
            }
        ) { food ->
            ProfileItem(
                foodCalData = food,
                navigateToProfileScreen = navigateToProfileScreen
            )
        }
    }

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

                Column(
                    Modifier.weight(2.0f)
                ) {
                    Text(
                        text = foodCalData.foodName,
                        color = MaterialTheme.colors.profileItemFoodColor,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        modifier = Modifier
                    )

                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Calories: ${foodCalData.calories}",
                        color = MaterialTheme.colors.profileItemTextColor,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(
                        text = "Carbohydrates: ${foodCalData.carbs}",
                        color = MaterialTheme.colors.profileItemTextColor,
                        style = MaterialTheme.typography.subtitle2
                    )
                }

                CircularProgress(
                    percentage = (
                            foodCalData.calories.toFloat() /
                                    (foodCalData.calories.toFloat() + foodCalData.carbs.toFloat())),
                    number = foodCalData.calories.toInt() + foodCalData.carbs.toInt()
                )
            }
        }
    }
}





@Composable
fun CircularProgress(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 14.sp,
    radius: Dp = 25.dp,
    color: Color = MaterialTheme.colors.progressBarColor,
    colorBackground: Color = MaterialTheme.colors.progressBackgroundColor,
    strokeWidth: Dp = 4.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {

//    var animationPlayed by remember {
//        mutableStateOf(false)
//    }
//
//    val curPercentage = animateFloatAsState(
//        targetValue = if (animationPlayed) percentage else 0f,
//        animationSpec = tween(
//            durationMillis = animDuration,
//            delayMillis = animDelay
//        )
//
//    )
//
//    LaunchedEffect(key1 = true) {
//        animationPlayed = true
//    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = colorBackground,
                startAngle = -90f,
                sweepAngle = 360F,
                useCenter = false,
                style = Stroke(
                    strokeWidth.toPx(),
                    cap = StrokeCap.Round
                )
            )

            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * percentage,
                useCenter = false,
                style = Stroke(
                    strokeWidth.toPx(),
                    cap = StrokeCap.Round
                )

            )
        }
        Text(
            text = (percentage * number).toInt().toString(),
            color = MaterialTheme.colors.profileItemTextColor,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
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
        "99",
    ), navigateToProfileScreen = {})
}