package com.mbh.moviebrowser.data.local

import com.mbh.moviebrowser.data.dataSources.ConfigurationDataSource
import com.mbh.moviebrowser.data.remote.MovieApi
import com.mbh.moviebrowser.domain.ImageConfiguration
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ConfigurationCacheDataSource @Inject constructor(
    private val movieApi: MovieApi,
) : ConfigurationDataSource {

    private var configurationCache: ImageConfiguration? = null

    override fun getConfiguration() =
        flow {
            if (configurationCache == null) {
                movieApi.fetchConfiguration().apply {
                    configurationCache = imageConfiguration
                }
            }
            emit(configurationCache!!)
        }

}