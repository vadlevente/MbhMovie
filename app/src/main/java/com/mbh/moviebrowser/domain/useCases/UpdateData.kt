package com.mbh.moviebrowser.domain.useCases

import com.mbh.moviebrowser.data.dataSources.GenreDataSource
import com.mbh.moviebrowser.data.dataSources.MovieDataSource
import javax.inject.Inject

class UpdateData @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val genreDataSource: GenreDataSource,
) {

    suspend operator fun invoke() {
        movieDataSource.fetchMovies()
        genreDataSource.fetchGenres()
    }

}