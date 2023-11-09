package com.mbh.moviebrowser.data.dataSources

import com.mbh.moviebrowser.domain.Genre
import kotlinx.coroutines.flow.Flow

interface GenreDataSource {
    val genres: Flow<List<Genre>>

    suspend fun fetchGenres()
}