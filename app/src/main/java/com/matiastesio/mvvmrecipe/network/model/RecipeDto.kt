package com.matiastesio.mvvmrecipe.network.model

data class RecipeDto (
    val pk: String? = null,
    val title: String? = null,
    val publisher: String? = null,
    val featuredImage: String? = null,
    val rating: Int? = 0,
    val sourceUrl: String? = null,
    val ingredients: List<String>? = emptyList(),
    val dateAdded: String? = null,
    val dateUpdated: String? = null,
    val description: String? = null,
    val coockingInstructions: String? = null,
)
