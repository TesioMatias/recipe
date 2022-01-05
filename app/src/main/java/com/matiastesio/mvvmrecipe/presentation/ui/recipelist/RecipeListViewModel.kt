package com.matiastesio.mvvmrecipe.presentation.ui.recipelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matiastesio.mvvmrecipe.domain.model.Recipe
import com.matiastesio.mvvmrecipe.usecase.RecipeUseCase
import com.matiastesio.mvvmrecipe.utils.MutableLiveResource
import com.matiastesio.mvvmrecipe.utils.getLiveData
import com.matiastesio.mvvmrecipe.utils.launchResource
import kotlinx.coroutines.launch

class RecipeListViewModel
@ViewModelInject
constructor(
    private val recipeUseCase: RecipeUseCase
) : ViewModel() {

    val recipe: MutableState<List<Recipe>> = mutableStateOf(listOf())

    val query = mutableStateOf("Chicken")

    init {
        newSearch(query.value)
    }

    fun newSearch(query: String) {
        viewModelScope.launch{
            val result = recipeUseCase(page = 1, query = query)
            recipe.value = result
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }
}