package com.mbh.moviebrowser.data.remote.model

import com.mbh.moviebrowser.domain.Genre

data class GenresResponseDto(
    val genres: List<Genre>
)
