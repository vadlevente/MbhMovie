package com.mbh.moviebrowser.domain.useCases

import com.mbh.moviebrowser.data.dataSources.MovieDataSource
import com.mbh.moviebrowser.data.dataSources.SelectedMovieDataSource
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class ToggleFavorite @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val selectedMovieDataSource: SelectedMovieDataSource,
) {

    suspend operator fun invoke() =
        selectedMovieDataSource.selectedMovieId.collectLatest { movieId ->
            movieDataSource.toggleIsFavorite(movieId)
        }

}