package com.mbh.moviebrowser.data.dataSources

import kotlinx.coroutines.flow.Flow

interface SelectedMovieDataSource {
    val selectedMovieId: Flow<Long>

    fun selectMovie(movieId: Long)
}