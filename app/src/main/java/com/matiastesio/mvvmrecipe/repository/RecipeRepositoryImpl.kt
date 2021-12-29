package com.matiastesio.mvvmrecipe.repository

import com.matiastesio.mvvmrecipe.domain.model.Recipe
import com.matiastesio.mvvmrecipe.network.RecipeService
import com.matiastesio.mvvmrecipe.network.model.RecipeDto
import com.matiastesio.mvvmrecipe.utils.GenericMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: GenericMapper<RecipeDto, Recipe>
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        val result = recipeService.search(token, page, query).results
        return mapper.mapToDomainModelList(result)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        val result = recipeService.get(token, id)
        return mapper.mapToDomainModel(result)
    }
}
