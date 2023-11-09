package com.mbh.moviebrowser.domain

data class Movie(
    val id: Long,
    val title: String,
    val genres: List<Genre>,
    val overview: String,
    val posterPath: String,
    val rating: Float,
    val isFavorite: Boolean,
)
