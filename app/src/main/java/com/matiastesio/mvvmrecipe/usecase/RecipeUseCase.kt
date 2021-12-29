package com.matiastesio.mvvmrecipe.usecase

import com.matiastesio.mvvmrecipe.domain.model.Recipe
import com.matiastesio.mvvmrecipe.repository.RecipeRepository

class RecipeUseCase(
    private val recipeRepository: RecipeRepository,
    private val authToken: String
) {

    suspend operator fun invoke(page: Int, query: String): List<Recipe> = recipeRepository.search(authToken, page,query)

}
