package com.mbh.moviebrowser.data.local

import com.mbh.moviebrowser.data.dataSources.MovieDataSource
import com.mbh.moviebrowser.data.remote.MovieApi
import com.mbh.moviebrowser.data.remote.model.MovieDto
import com.mbh.moviebrowser.domain.Genre
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class MovieCacheDataSource @Inject constructor(
    private val movieApi: MovieApi,
) : MovieDataSource {

    private val moviesCache = MutableStateFlow<List<MovieDto>>(emptyList())
    private val genresCache = MutableStateFlow<List<Genre>>(emptyList())

    override val movies = combine(moviesCache, genresCache)
        { movieList, genres -> Pair(movieList, genres) }
        .map { (movieList, genres) ->
            movieList.map { movie ->
                movie.toModel(genres.filter { movie.genreIds.contains(it.id) })
            }
        }

    override suspend fun fetchMovies() {
        moviesCache.emit(movieApi.fetchTrending().results)
        genresCache.emit(movieApi.fetchGenres().genres)
    }

    override fun toggleIsFavorite(movieId: Long) {
        moviesCache.update {
            it.map { movie ->
                movie.takeIf { it.id == movieId }?.copy(isFavorite = !movie.isFavorite) ?: movie
            }
        }
    }

}