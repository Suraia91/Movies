package ao.com.dio.movieslist.data

import ao.com.dio.movieslist.domain.Movie

interface MovieDataSource {
 fun getAllMovies():List<Movie>
}