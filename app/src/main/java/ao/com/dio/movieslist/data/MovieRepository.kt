package ao.com.dio.movieslist.data

class MovieRepository(private val movieDataSource: MovieDataSource) {

fun getAllMovieFromDataSource()= movieDataSource.getAllMovies()
}