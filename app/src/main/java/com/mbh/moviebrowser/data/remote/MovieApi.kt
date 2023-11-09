package com.mbh.moviebrowser.data.remote

import com.mbh.moviebrowser.data.remote.model.GenresResponseDto
import com.mbh.moviebrowser.data.remote.model.MoviesResponseDto
import com.mbh.moviebrowser.domain.ApiConfiguration
import retrofit2.http.GET

interface MovieApi {

    @GET("trending/movie/day")
    suspend fun fetchTrending(): MoviesResponseDto

    @GET("genre/movie/list")
    suspend fun fetchGenres(): GenresResponseDto

    @GET("configuration")
    suspend fun fetchConfiguration(): ApiConfiguration

}