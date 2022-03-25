package ao.com.dio.movieslist.ui

import ao.com.dio.movieslist.domain.Movie

interface ClickListenerMovieList {
    fun setOnClickItemMovie(movie: Movie)
}