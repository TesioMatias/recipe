package com.matiastesio.mvvmrecipe.model.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
    val id: String? = null,
    val title: String? = null,
    val publisher: String? = null,
    val featuredImage: String? = null,
    val rating: Int? = 0,
    val sourceUrl: String? = null,
    val description: String? = null,
    val coockingInstructions: String? = null,
    val ingredients: List<String>? = listOf(),
    val dataAdded: String? = null,
    val dataUpdated: String? = null
) : Parcelable
