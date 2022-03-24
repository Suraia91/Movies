package ao.com.dio.movieslist.implementations

import android.util.Log
import ao.com.dio.movieslist.framework.api.MovieRestApiTask
import ao.com.dio.movieslist.data.MovieDataSource
import ao.com.dio.movieslist.domain.Movie

class MovieDataSourceImplementations(val movieRestApiTask: MovieRestApiTask):MovieDataSource {

    companion object{
        const val TAG="MovieRepository"
    }

    private val movieList= arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
        val request= movieRestApiTask.retrofitAPi().getAllMovies().execute()

        if (request.isSuccessful){

            request.body()?.let{
                movieList.addAll(it)
            }

        }else{
            request.errorBody()?.let {
                Log.d(TAG,it.toString())
            }
        }

        return movieList
    }
}