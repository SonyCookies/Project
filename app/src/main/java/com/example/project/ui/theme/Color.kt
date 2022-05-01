package com.example.project.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)


val BlueSky = Color(0xFF334195)
val Charcoal = Color(0xFF2E4057)
val BlueJeans = Color(0xFF33A1FD)
val YellowOrange = Color(0xFFF79824)
val White = Color(0xFFFFFFFF)

val Jet = Color(0xFF363636)
val DarkGray = Color(0xFF141414)
val Satin = Color(0xFFCCA43B)
val Gunmetal = Color(0xFF242F40)
val Platinum = Color(0xFFE5E5E5)


val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if(isLight) Platinum else Color.Black

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if(isLight) DarkGray else LightGray

val Colors.profileItemBackgroundColor: Color
    @Composable
    get() = if(isLight) Platinum else DarkGray

val Colors.profileItemTextColor: Color
    @Composable
    get() = if(isLight) Gunmetal else LightGray

val Colors.profileItemFoodColor: Color
    @Composable
    get() = if(isLight) DarkGray else White

val Colors.fabBackgroundColor: Color
    @Composable
    get() = if(isLight) Satin else Charcoal

val Colors.progressBackgroundColor: Color
    @Composable
    get() = if(isLight) Jet else MediumGray

val Colors.progressBarColor: Color
    @Composable
    get() = if(isLight) Satin else LightGray