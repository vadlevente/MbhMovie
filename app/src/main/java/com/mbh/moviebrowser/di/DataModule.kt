package com.mbh.moviebrowser.di

import com.mbh.moviebrowser.data.dataSources.ConfigurationDataSource
import com.mbh.moviebrowser.data.dataSources.GenreDataSource
import com.mbh.moviebrowser.data.dataSources.MovieDataSource
import com.mbh.moviebrowser.data.dataSources.SelectedMovieDataSource
import com.mbh.moviebrowser.data.local.ConfigurationCacheDataSource
import com.mbh.moviebrowser.data.local.GenreCacheDataSource
import com.mbh.moviebrowser.data.local.MovieCacheDataSource
import com.mbh.moviebrowser.data.local.SelectedMovieCacheDataSource
import com.mbh.moviebrowser.data.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(
        movieApi: MovieApi
    ): MovieDataSource = MovieCacheDataSource(movieApi)

    @Provides
    @Singleton
    fun provideGenreDataSource(
        movieApi: MovieApi
    ): GenreDataSource = GenreCacheDataSource(movieApi)

    @Provides
    @Singleton
    fun provideConfigurationDataSource(
        movieApi: MovieApi
    ): ConfigurationDataSource = ConfigurationCacheDataSource(movieApi)

    @Provides
    @Singleton
    fun provideSelectedMovieDataSource(): SelectedMovieDataSource = SelectedMovieCacheDataSource()

}