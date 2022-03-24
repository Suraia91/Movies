package ao.com.dio.movieslist.usecase

import ao.com.dio.movieslist.data.MovieRepository

class MovieListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke()=movieRepository.getAllMovieFromDataSource()
}