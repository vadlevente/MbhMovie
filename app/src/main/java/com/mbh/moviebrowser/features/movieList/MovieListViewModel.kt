package com.mbh.moviebrowser.features.movieList

import androidx.lifecycle.viewModelScope
import com.mbh.moviebrowser.domain.useCases.GetMovies
import com.mbh.moviebrowser.domain.useCases.SelectMovie
import com.mbh.moviebrowser.domain.useCases.UpdateData
import com.mbh.moviebrowser.ui.ViewModelBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    getMovies: GetMovies,
    private val selectMovie: SelectMovie,
    private val updateData: UpdateData,
) : ViewModelBase() {
    val movies = getMovies().asState(emptyList())

    init {
        viewModelScope.launch {
            updateData()
        }
    }

    fun storeMovieForNavigation(movieId: Long) = selectMovie(movieId)
}
