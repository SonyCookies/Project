package com.example.project.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.model.FoodCalData
import com.example.project.data.repository.FoodCalRepository
import com.example.project.util.RequestState
import com.example.project.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: FoodCalRepository
): ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> =
        mutableStateOf("")

    private val _allFoods =
        MutableStateFlow<RequestState<List<FoodCalData>>>(RequestState.Idle)
    val allFoods: StateFlow<RequestState<List<FoodCalData>>> = _allFoods

    fun getAllFoods() {
        _allFoods.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllFoods.collect {
                    _allFoods.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allFoods.value = RequestState.Error(e)

        }
    }
}
