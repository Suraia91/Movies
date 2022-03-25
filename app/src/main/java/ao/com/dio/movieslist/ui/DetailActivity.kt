package ao.com.dio.movieslist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import ao.com.dio.movieslist.R
import ao.com.dio.movieslist.domain.Movie
import coil.load
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initTooBar()
        getExtras()
        bindViews()
    }

   private fun initTooBar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtras() {
        movie = intent.getParcelableExtra(EXTRACT_MOVIE)
    }

    private fun bindViews() {
        iv_detail_movie.load(movie?.imagem) {
            placeholder(R.drawable.ic_image)
            fallback(R.drawable.ic_image)
        }
        movie_detail_Title.text = movie?.titulo
        movie_detail_date.text = movie?.dataLancamento
        movie_detail_description.text = movie?.descricao
    }

    companion object {
        const val EXTRACT_MOVIE: String = "EXTRACT_MOVIE"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}