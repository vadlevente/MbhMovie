package com.mbh.moviebrowser.data.remote.model

import com.google.gson.annotations.SerializedName
import com.mbh.moviebrowser.domain.Movie

data class MovieDto(
    val id: Long,
    val title: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val rating: Float,
) {
    fun toModel() = Movie(
        id = id,
        title = title,
        genreIds = genreIds,
        overview = overview,
        posterPath = posterPath,
        rating = rating,
    )
}
