package com.matiastesio.mvvmrecipe.usecase

import com.matiastesio.mvvmrecipe.domain.model.Recipe
import com.matiastesio.mvvmrecipe.repository.RecipeRepository

class RecipeUseCase(
    private val recipeRepository: RecipeRepository,
    private val authToken: String
) {

    suspend operator fun invoke(recipeNumber: Int): Recipe? = recipeRepository.get(authToken, recipeNumber)

}
