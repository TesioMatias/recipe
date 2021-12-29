package com.matiastesio.mvvmrecipe.network.model

data class RecipeSearchDto(
    val count: Int? = 0,
    val results: List<RecipeDto> = listOf()
)
