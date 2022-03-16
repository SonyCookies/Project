package com.example.project.data.repository

import com.example.project.data.FoodCalDao
import com.example.project.data.model.FoodCalData
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class FoodCalRepository @Inject constructor(private val foodCalDao: FoodCalDao) {

    val getAllFoods: Flow<List<FoodCalData>> = foodCalDao.getAllFoods()

    fun getSelectedFood(profileId: Int): Flow<FoodCalData> {
        return foodCalDao.getSelectedFood(profileId = profileId)
    }

    suspend fun addFood(foodCalData: FoodCalData) {
        foodCalDao.addFood(foodCalData = foodCalData)
    }

    suspend fun updateFood(foodCalData: FoodCalData){
        foodCalDao.updateFood(foodCalData = foodCalData)
    }

    suspend fun deleteFood(foodCalData: FoodCalData) {
        foodCalDao.deleteFood(foodCalData = foodCalData)
    }

    fun searchDatabase(searchQuery: String): Flow<List<FoodCalData>> {
        return foodCalDao.searchDataBase(searchQuery = searchQuery)
    }
}