package com.mbh.moviebrowser.domain

data class DisplayedMovie(
    val id: Long,
    val title: String,
    val genres: String,
    val overview: String,
    val coverUrl: String,
    val rating: Float,
    val isFavorite: Boolean,
)
