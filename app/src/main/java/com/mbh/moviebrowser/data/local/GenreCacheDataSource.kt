package com.mbh.moviebrowser.data.local

import com.mbh.moviebrowser.data.dataSources.GenreDataSource
import com.mbh.moviebrowser.data.remote.MovieApi
import com.mbh.moviebrowser.domain.Genre
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class GenreCacheDataSource @Inject constructor(
    private val movieApi: MovieApi,
) : GenreDataSource {
    private val genresCache = MutableStateFlow<List<Genre>>(emptyList())

    override val genres = genresCache

    override suspend fun fetchGenres() {
        genresCache.emit(movieApi.fetchGenres().genres)
    }

}