package com.mbh.moviebrowser.data.dataSources

import com.mbh.moviebrowser.domain.ImageConfiguration
import kotlinx.coroutines.flow.Flow

interface ConfigurationDataSource {
    fun getConfiguration(): Flow<ImageConfiguration>
}