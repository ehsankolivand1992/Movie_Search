package com.sprout.data.entities.mapper

import com.sprout.data.entities.RemoteMoviesModel
import com.sprout.domain.model.Movies

fun RemoteMoviesModel.toMovies(): List<Movies> {
   return this.data.videos.map {
        Movies(it.title,it.summary,it.rate,it.duration,it.poster_image.path,it.cover_image.path,it.year)
    }
}