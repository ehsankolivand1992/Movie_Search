package com.sprout.moviesearch

import androidx.lifecycle.ViewModel
import com.sprout.domain.usecases.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: SearchMoviesUseCase): ViewModel() {


    }

