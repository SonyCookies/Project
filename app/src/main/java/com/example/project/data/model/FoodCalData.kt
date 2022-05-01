package com.example.project.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.project.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class FoodCalData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val foodName: String,
    val calories: String,
    val carbs: String,
)