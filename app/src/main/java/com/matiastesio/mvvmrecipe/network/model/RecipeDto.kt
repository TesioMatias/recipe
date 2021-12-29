package com.matiastesio.mvvmrecipe.network.model

import com.google.gson.annotations.SerializedName

data class RecipeDto (
    val pk: String? = null,
    val title: String? = null,
    val publisher: String? = null,
    @SerializedName("featured_image")
    val featuredImage: String? = null,
    val rating: Int? = 0,
    @SerializedName("source_url")
    val sourceUrl: String? = null,
    val ingredients: List<String>? = emptyList(),
    val dateAdded: String? = null,
    val dateUpdated: String? = null,
    val description: String? = null,
    @SerializedName("coocking_instructions")
    val coockingInstructions: String? = null,
)
