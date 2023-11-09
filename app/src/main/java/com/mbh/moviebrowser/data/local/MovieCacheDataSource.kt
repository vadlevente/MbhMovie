package com.mbh.moviebrowser.data.local

import com.mbh.moviebrowser.data.dataSources.MovieDataSource
import com.mbh.moviebrowser.data.remote.MovieApi
import com.mbh.moviebrowser.domain.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class MovieCacheDataSource @Inject constructor(
    private val movieApi: MovieApi,
) : MovieDataSource {

    private val moviesCache = MutableStateFlow<List<Movie>>(emptyList())

    override val movies = moviesCache

    override suspend fun fetchMovies() {
        moviesCache.emit(movieApi.fetchTrending().results.map {
            it.toModel()
        })
    }

    override fun toggleIsFavorite(movieId: Long) {
        moviesCache.update {
            it.map { movie ->
                movie.takeIf { it.id == movieId }?.copy(isFavorite = !movie.isFavorite) ?: movie
            }
        }
    }

}