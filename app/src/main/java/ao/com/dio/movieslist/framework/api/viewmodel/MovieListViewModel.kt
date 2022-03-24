package ao.com.dio.movieslist.framework.api.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ao.com.dio.movieslist.framework.api.MovieRestApiTask
import ao.com.dio.movieslist.data.MovieRepository
import ao.com.dio.movieslist.domain.Movie
import ao.com.dio.movieslist.implementations.MovieDataSourceImplementations
import ao.com.dio.movieslist.usecase.MovieListUseCase
import java.lang.Exception

class MovieListViewModel : ViewModel() {
    companion object {
        const val TAG = "MovieListViewModel"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDatasource=MovieDataSourceImplementations(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDatasource)
    private val movieListUseCase=MovieListUseCase(movieRepository)


    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(movieListUseCase.invoke())

            } catch (ex: Exception) {
                Log.d(TAG, ex.message.toString())
            }
        }.start()
    }

}