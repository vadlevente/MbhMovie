package com.mbh.moviebrowser.di

import com.mbh.moviebrowser.data.remote.ApiKeyInterceptor
import com.mbh.moviebrowser.data.remote.ApiKeyInterceptorImpl
import com.mbh.moviebrowser.data.remote.MovieApi
import com.mbh.moviebrowser.di.NamedModule.API_KEY
import com.mbh.moviebrowser.di.NamedModule.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMovieApi(
        @Named(BASE_URL) baseUrl: String,
        apiKeyInterceptor: ApiKeyInterceptor
    ): MovieApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(apiKeyInterceptor)
                .addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieApi::class.java)

    @Provides
    @Singleton
    fun provideApiKeyInterceptor(
        @Named(API_KEY) apiKey: String,
    ): ApiKeyInterceptor = ApiKeyInterceptorImpl(apiKey)

}