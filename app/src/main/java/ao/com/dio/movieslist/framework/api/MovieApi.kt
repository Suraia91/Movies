package ao.com.dio.movieslist.framework.api

import ao.com.dio.movieslist.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    //https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies():Call<List<Movie>>
}