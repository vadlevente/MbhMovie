package com.mbh.moviebrowser.domain.useCases

import com.mbh.moviebrowser.data.dataSources.ConfigurationDataSource
import com.mbh.moviebrowser.data.dataSources.GenreDataSource
import com.mbh.moviebrowser.data.dataSources.MovieDataSource
import com.mbh.moviebrowser.domain.DisplayedMovie
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetMovies @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val genreDataSource: GenreDataSource,
    private val configurationDataSource: ConfigurationDataSource,
) {

    operator fun invoke() =
        combine(
            configurationDataSource.getConfiguration(),
            movieDataSource.movies,
            genreDataSource.genres
        ) { configuration, movies, genres ->
            movies.map { movie ->
                DisplayedMovie(
                    id = movie.id,
                    title = movie.title,
                    genres = genres.filter { movie.genreIds.contains(it.id) }.joinToString { it.name },
                    overview = movie.overview,
                    coverUrl = "${configuration.thumbnailBaseUrl}${movie.posterPath}",
                    rating = movie.rating,
                    isFavorite = movie.isFavorite,
                )
            }
        }


}