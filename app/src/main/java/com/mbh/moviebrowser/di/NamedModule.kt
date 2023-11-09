package com.mbh.moviebrowser.di

import com.mbh.moviebrowser.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NamedModule {

    @Provides
    @Named(BASE_URL)
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Named(API_KEY)
    fun provideApiKey() = BuildConfig.API_KEY

    const val BASE_URL = "baseUrl"
    const val API_KEY = "apiKey"

}