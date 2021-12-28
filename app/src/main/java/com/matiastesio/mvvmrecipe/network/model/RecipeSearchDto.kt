package com.matiastesio.mvvmrecipe.network.model

data class RecipeSearchDto(
    val count: Int? = 0,
    val recipes: List<RecipeDto>? = listOf()
)
