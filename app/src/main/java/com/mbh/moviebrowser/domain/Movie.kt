package com.mbh.moviebrowser.domain

data class Movie(
    val id: Long,
    val title: String,
    val genreIds: List<Int>,
    val overview: String,
    val posterPath: String,
    val rating: Float,
    val isFavorite: Boolean = false,
)
