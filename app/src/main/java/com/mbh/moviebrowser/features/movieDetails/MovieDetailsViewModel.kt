package com.mbh.moviebrowser.features.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbh.moviebrowser.domain.useCases.GetMovie
import com.mbh.moviebrowser.domain.useCases.ToggleFavorite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    getMovie: GetMovie,
    private val toggleFavorite: ToggleFavorite,
) : ViewModel() {

    val movie = getMovie()

    fun onFavoriteClicked() {
        viewModelScope.launch {
            toggleFavorite()
        }
    }
}
