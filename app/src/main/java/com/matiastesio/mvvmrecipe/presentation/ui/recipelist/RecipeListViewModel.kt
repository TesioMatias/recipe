package com.matiastesio.mvvmrecipe.presentation.ui.recipelist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matiastesio.mvvmrecipe.domain.model.Recipe
import com.matiastesio.mvvmrecipe.usecase.RecipeUseCase
import com.matiastesio.mvvmrecipe.utils.MutableLiveResource
import com.matiastesio.mvvmrecipe.utils.getLiveData
import com.matiastesio.mvvmrecipe.utils.launchResource

class RecipeListViewModel
@ViewModelInject
constructor(
    private val recipeUseCase: RecipeUseCase
) : ViewModel() {

    private val _recipeResponse = MutableLiveResource<Recipe?>()
    val recipeResponse by getLiveData(_recipeResponse)

    fun getRecipe(recipeNumber: Int) = viewModelScope.launchResource(_recipeResponse, {
        recipeUseCase(recipeNumber)
    })
}