package com.mbh.moviebrowser.di

import com.mbh.moviebrowser.data.dataSources.ConfigurationDataSource
import com.mbh.moviebrowser.data.dataSources.GenreDataSource
import com.mbh.moviebrowser.data.dataSources.MovieDataSource
import com.mbh.moviebrowser.data.dataSources.SelectedMovieDataSource
import com.mbh.moviebrowser.domain.useCases.GetMovie
import com.mbh.moviebrowser.domain.useCases.GetMovies
import com.mbh.moviebrowser.domain.useCases.SelectMovie
import com.mbh.moviebrowser.domain.useCases.ToggleFavorite
import com.mbh.moviebrowser.domain.useCases.UpdateData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMoviesUseCase(
        movieDataSource: MovieDataSource,
        genreDataSource: GenreDataSource,
        configurationDataSource: ConfigurationDataSource,
    ): GetMovies = GetMovies(movieDataSource, genreDataSource, configurationDataSource)

    @Provides
    @Singleton
    fun provideGetMovieUseCase(
        movieDataSource: MovieDataSource,
        genreDataSource: GenreDataSource,
        configurationDataSource: ConfigurationDataSource,
        selectedMovieDataSource: SelectedMovieDataSource,
    ): GetMovie = GetMovie(movieDataSource, genreDataSource, configurationDataSource, selectedMovieDataSource)

    @Provides
    @Singleton
    fun provideSelectMovieUseCase(
        selectedMovieDataSource: SelectedMovieDataSource,
    ): SelectMovie = SelectMovie(selectedMovieDataSource)

    @Provides
    @Singleton
    fun provideToggleFavoriteUseCase(
        movieDataSource: MovieDataSource,
        selectedMovieDataSource: SelectedMovieDataSource,
    ): ToggleFavorite = ToggleFavorite(movieDataSource, selectedMovieDataSource)

    @Provides
    @Singleton
    fun provideUpdateDataUseCase(
        movieDataSource: MovieDataSource,
        genreDataSource: GenreDataSource,
    ): UpdateData = UpdateData(movieDataSource, genreDataSource)

}