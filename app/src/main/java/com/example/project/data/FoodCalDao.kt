package com.example.project.data

import androidx.room.*
import com.example.project.data.model.FoodCalData
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodCalDao {

    @Query("SELECT * FROM food_table ORDER BY id ASC")
    fun getAllFoods(): Flow<List<FoodCalData>>

    @Query("SELECT * FROM food_table WHERE id=:profileId")
    fun getSelectedFood(profileId: Int): Flow<FoodCalData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFood(foodCalData: FoodCalData)

    @Update
    suspend fun updateFood(foodCalData: FoodCalData)

    @Delete
    suspend fun deleteFood(foodCalData: FoodCalData)


    @Query("SELECT * FROM food_table WHERE foodName LIKE :searchQuery")
    fun searchDataBase(searchQuery: String): Flow<List<FoodCalData>>

}