package com.mbh.moviebrowser.data.local

import com.mbh.moviebrowser.data.dataSources.SelectedMovieDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class SelectedMovieCacheDataSource @Inject constructor() : SelectedMovieDataSource {

    private val selectedMovieIdCache = MutableStateFlow(0L)

    override val selectedMovieId = selectedMovieIdCache

    override fun selectMovie(movieId: Long) {
        selectedMovieIdCache.update { movieId }
    }

}