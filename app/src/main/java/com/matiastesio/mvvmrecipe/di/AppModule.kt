package com.matiastesio.mvvmrecipe.di

import android.content.Context
import com.matiastesio.mvvmrecipe.BaseApplication
import com.matiastesio.mvvmrecipe.network.RecipeService
import com.matiastesio.mvvmrecipe.repository.RecipeRepository
import com.matiastesio.mvvmrecipe.usecase.RecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }
}