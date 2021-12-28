package com.matiastesio.mvvmrecipe.network

import com.matiastesio.mvvmrecipe.network.model.RecipeDto
import com.matiastesio.mvvmrecipe.network.model.RecipeSearchDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService {

    @GET(value = "search")
    suspend fun search(
        @Header(value = "Authorization") token: String,
        @Query(value = "Page") page: Int,
        @Query(value = "Query") query: String
    ) : RecipeSearchDto

    @GET(value = "get")
    suspend fun get(
        @Header(value = "Authorization") token: String,
        @Query(value = "Id") id: Int,
    ) : RecipeDto

}
