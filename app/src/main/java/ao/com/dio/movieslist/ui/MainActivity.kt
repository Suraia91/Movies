package ao.com.dio.movieslist.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ao.com.dio.movieslist.R
import ao.com.dio.movieslist.domain.Movie
import ao.com.dio.movieslist.framework.api.viewmodel.MovieListViewModel
import ao.com.dio.movieslist.ui.DetailActivity.Companion.EXTRACT_MOVIE
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ClickListenerMovieList {

    private lateinit var movieListViewModel: MovieListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieListViewModel =
            ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        loadingProgress(true)
        initObserver()
    }

    private fun initObserver() {
        movieListViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()) {
                loadingProgress(false)
                populateList(list)
            }
        })
    }

    private fun populateList(list: List<Movie>) {
        movieList.apply {
            hasFixedSize()
            adapter = MovieAdapter(list, this@MainActivity)
        }
    }

    private fun loadingProgress(isLoadin: Boolean) {
        progressBar.visibility = if (isLoadin) View.VISIBLE else View.GONE
    }

    override fun setOnClickItemMovie(movie: Movie) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRACT_MOVIE, movie)
        startActivity(intent)
    }
}