package com.example.project.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project.data.FoodCalDao

@Database(entities = [FoodCalData::class], version = 1, exportSchema = false)
abstract class FoodCalDatabase: RoomDatabase() {

    abstract fun foodCalDao(): FoodCalDao

}