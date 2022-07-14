package com.sprout.data.network.repository

import android.util.Log
import com.sprout.data.network.api.MoviesApi
import com.sprout.data.network.dataSource.MoviesRemoteDataSource
import com.sprout.domain.model.Movies
import com.sprout.domain.repository.MoviesRepository
import com.sprout.domain.responseModel.ResultData
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(private val remoteDataSource: MoviesRemoteDataSource):MoviesRepository {

    override suspend fun search(search: String): ResultData<List<Movies>> {
        Log.i("testtt","repo")

        return remoteDataSource.searchMovies(search)
    }
}