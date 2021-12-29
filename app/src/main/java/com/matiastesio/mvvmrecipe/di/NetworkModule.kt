package com.matiastesio.mvvmrecipe.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.matiastesio.mvvmrecipe.BuildConfig
import com.matiastesio.mvvmrecipe.network.RecipeService
import com.matiastesio.mvvmrecipe.network.utils.RecipeMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper(): RecipeMapper {
        return RecipeMapper()
    }

    @Singleton
    @Provides
    fun provideRecipeService(): RecipeService {
         return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)
    }
}
