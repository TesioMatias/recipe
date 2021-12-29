package com.matiastesio.mvvmrecipe.di

import com.matiastesio.mvvmrecipe.BuildConfig
import com.matiastesio.mvvmrecipe.network.RecipeService
import com.matiastesio.mvvmrecipe.network.utils.RecipeMapper
import com.matiastesio.mvvmrecipe.repository.RecipeRepository
import com.matiastesio.mvvmrecipe.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRecipeRepository(
        recipeService: RecipeService,
        recipeMapper: RecipeMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService = recipeService,
            mapper = recipeMapper
        )
    }

    @Singleton
    @Provides
    fun providesAuthToken() : String {
        return BuildConfig.AUTH_TOKEN
    }
}