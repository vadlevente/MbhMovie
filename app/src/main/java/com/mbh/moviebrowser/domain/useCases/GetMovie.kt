package com.mbh.moviebrowser.domain.useCases

import com.mbh.moviebrowser.data.dataSources.ConfigurationDataSource
import com.mbh.moviebrowser.data.dataSources.MovieDataSource
import com.mbh.moviebrowser.data.dataSources.SelectedMovieDataSource
import com.mbh.moviebrowser.domain.DisplayedMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetMovie @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val configurationDataSource: ConfigurationDataSource,
    private val selectedMovieDataSource: SelectedMovieDataSource,
) {

    operator fun invoke(): Flow<DisplayedMovie> =
        combine(
            selectedMovieDataSource.selectedMovieId,
            configurationDataSource.getConfiguration(),
            movieDataSource.movies,
        ) { movieId, configuration, movies ->
            movies.first { it.id == movieId }
                .let { movie ->
                    DisplayedMovie(
                        id = movie.id,
                        title = movie.title,
                        genres = movie.genres.joinToString { it.name },
                        overview = movie.overview,
                        coverUrl = "${configuration.posterBaseUrl}/${movie.posterPath}",
                        rating = movie.rating,
                        isFavorite = movie.isFavorite,
                    )
                }
        }

}