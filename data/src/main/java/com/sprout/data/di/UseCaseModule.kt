package com.sprout.data.di

import com.sprout.data.network.repository.MoviesRepositoryImp
import com.sprout.domain.usecases.SearchMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideMoviesUseCase(repositoryImp: MoviesRepositoryImp)=SearchMoviesUseCase(repositoryImp)
}