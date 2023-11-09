package com.mbh.moviebrowser.domain.useCases

import com.mbh.moviebrowser.data.dataSources.MovieDataSource
import javax.inject.Inject

class UpdateData @Inject constructor(
    private val movieDataSource: MovieDataSource,
) {

    suspend operator fun invoke() = movieDataSource.fetchMovies()

}