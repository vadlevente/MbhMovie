package com.mbh.moviebrowser.domain.useCases

import com.mbh.moviebrowser.data.dataSources.SelectedMovieDataSource
import javax.inject.Inject

class SelectMovie @Inject constructor(
    private val selectedMovieDataSource: SelectedMovieDataSource,
) {

    operator fun invoke(movieId: Long) = selectedMovieDataSource.selectMovie(movieId)

}