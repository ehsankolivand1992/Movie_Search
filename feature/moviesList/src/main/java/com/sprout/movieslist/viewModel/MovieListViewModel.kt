package com.sprout.movieslist.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sprout.baseui.BaseViewModel
import com.sprout.domain.model.Movies
import com.sprout.domain.responseModel.ResultData
import com.sprout.domain.usecases.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val useCase: SearchMoviesUseCase) : BaseViewModel() {


    fun searchMovies(query:String)= liveData {

        loading.postValue(true)
        emit(useCase.invoke(query))
        loading.postValue(false)

    }
}