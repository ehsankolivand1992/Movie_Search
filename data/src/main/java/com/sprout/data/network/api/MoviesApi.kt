package com.sprout.data.network.api

import com.sprout.data.entities.MoviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApi {

        @Headers("X-Platform: Android")
        @GET("search")
        suspend fun search(@Query("query") query: String): Response<MoviesModel>
}