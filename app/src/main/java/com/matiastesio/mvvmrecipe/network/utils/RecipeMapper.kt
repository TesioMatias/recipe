package com.matiastesio.mvvmrecipe.network.utils

import com.matiastesio.mvvmrecipe.domain.model.Recipe
import com.matiastesio.mvvmrecipe.network.model.RecipeDto
import com.matiastesio.mvvmrecipe.utils.GenericMapper

class RecipeMapper : GenericMapper<RecipeDto, Recipe> {

    override fun mapToDomainModel(dto: RecipeDto): Recipe {
        return Recipe(
            id = dto.pk,
            title = dto.title,
            publisher = dto.publisher,
            featuredImage = dto.featuredImage,
            rating = dto.rating,
            sourceUrl = dto.sourceUrl,
            description = dto.description,
            coockingInstructions = dto.coockingInstructions,
            ingredients = dto.ingredients,
            dataAdded = dto.dateAdded,
            dataUpdated = dto.dateUpdated
        )
    }

    override fun mapFromDomainModel(model: Recipe): RecipeDto {
        return RecipeDto(
            pk = model.id,
            title = model.title,
            publisher = model.publisher,
            featuredImage = model.featuredImage,
            rating = model.rating,
            sourceUrl = model.sourceUrl,
            description = model.description,
            coockingInstructions = model.coockingInstructions,
            ingredients = model.ingredients,
            dateAdded = model.dataAdded,
            dateUpdated = model.dataUpdated
        )
    }

    override fun mapToDomainModelList(initial: List<RecipeDto>) : List<Recipe> {
        return initial.map { mapToDomainModel(it) }
    }

    override fun mapFromDomainModelList(initial: List<Recipe>) : List<RecipeDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}
