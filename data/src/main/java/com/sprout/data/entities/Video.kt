package com.sprout.data.entities

data class Video(
    val age_restriction: String,
    val alter_cover_image: AlterCoverImage,
    val categories: List<CategoryX>,
    val conditional_flag: String,
    val cover_image: CoverImageX,
    val duration: String,
    val flag: String,
    val id: String,
    val imdb_rank_percent: Int,
    val logo_image: LogoImageX,
    val original_name: String,
    val page_title: String,
    val poster_image: PosterImageX,
    val rate: Double,
    val short_id: String,
    val slug: String,
    val status: String,
    val summary: String,
    val title: String,
    val type: String,
    val year: Int
)