package com.mbh.moviebrowser.data.remote

import com.mbh.moviebrowser.di.NamedModule.API_KEY
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

interface ApiKeyInterceptor : Interceptor

class ApiKeyInterceptorImpl @Inject constructor(
    @Named(API_KEY) private val apiKey: String,
) : ApiKeyInterceptor {

    override fun intercept(chain: Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .url(
                original.url.newBuilder()
                    .addQueryParameter(API_KEY_PARAMETER_NAME, apiKey)
                    .build()
            )
        return chain.proceed(requestBuilder.build())
    }

    companion object {
        const val API_KEY_PARAMETER_NAME = "api_key"
    }
}
