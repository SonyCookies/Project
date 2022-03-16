package com.example.project.ui.theme

import android.hardware.lights.Light
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val BlueSky = Color(0xFF334195)
val Charcoal = Color(0xFF2E4057)
val BlueJeans = Color(0xFF33A1FD)
val YellowOrange = Color(0xFFF79824)
val White = Color(0xFFFFFFFF)


val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if(isLight) White else Color.Black

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if(isLight) BlueSky else LightGray

val Colors.startScreenColor: Color
    @Composable
    get() = if(isLight) BlueSky else Color.Black

val Colors.categoryBackgroundColor: Color
    @Composable
    get() = if(isLight) Color.White else DarkGray

val Colors.categoryTextColor: Color
    @Composable
    get() = if(isLight) DarkGray else LightGray

val Colors.profileItemBackgroundColor: Color
    @Composable
    get() = if(isLight) Color.White else DarkGray

val Colors.profileItemTextColor: Color
    @Composable
    get() = if(isLight) DarkGray else LightGray