package com.sprout.data.network.dataSource

import com.sprout.data.entities.RemoteMoviesModel
import com.sprout.data.entities.mapper.toMovies
import com.sprout.data.network.api.MoviesApi
import com.sprout.domain.di.IoDispatcher
import com.sprout.domain.model.Movies
import com.sprout.domain.responseModel.ResultData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor
    (private val api :MoviesApi, @IoDispatcher private val dispatcher: CoroutineDispatcher) {

    suspend fun searchMovies(query: String): ResultData<List<Movies>> {
        return when (val response = processCall(dispatcher) {
            api.search(query)
        }
        ) {
            is RemoteMoviesModel -> {
            ResultData.success(response.toMovies())
            }
            is ResultData.Failure<*> ->{
                ResultData.failure("You got Error")

            }else ->  {
                ResultData.failure("You got Error")
            }
            }
        }
    }

    private suspend fun processCall( dispatcher: CoroutineDispatcher,
                                     responseCall: suspend () -> Response<*>): Any? {

        return withContext(dispatcher) {
            try {
                val response = responseCall.invoke()
                val responseCode = response.code()
                when {
                    response.isSuccessful -> {
                        response.body()
                    }
                    response.message() != null -> {
                        ResultData.Failure<String>("Unknown Error")
                    }
                    else -> {
                        "${response.message()} $responseCode"
                    }
                }
            } catch (e: IOException) {
                ResultData.Failure<String>("Connection Error")
            }
        }

}
