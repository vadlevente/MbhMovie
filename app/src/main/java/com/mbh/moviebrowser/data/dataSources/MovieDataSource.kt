package com.mbh.moviebrowser.data.dataSources

import com.mbh.moviebrowser.domain.Movie
import kotlinx.coroutines.flow.Flow

interface MovieDataSource {
    val movies: Flow<List<Movie>>

    fun toggleIsFavorite(movieId: Long)
    suspend fun fetchMovies()
}