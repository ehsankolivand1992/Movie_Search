package com.sprout.domain.repository

import com.sprout.domain.model.Movies
import com.sprout.domain.responseModel.ResultData

interface MoviesRepository {
    suspend fun search(search: String): ResultData<List<Movies>>
}