package com.matiastesio.mvvmrecipe.di

import com.matiastesio.mvvmrecipe.repository.RecipeRepository
import com.matiastesio.mvvmrecipe.usecase.RecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providesGetRecipeUseCase(
        recipeRepository: RecipeRepository,
        authToken: String
    ) : RecipeUseCase {
        return RecipeUseCase(recipeRepository, authToken)
    }
}