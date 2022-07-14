package com.sprout.domain.usecases

import com.sprout.domain.repository.MoviesRepository

class SearchMoviesUseCase(private val repository: MoviesRepository) {
    suspend operator fun invoke(search:String) = repository.search(search)
}