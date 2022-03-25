package ao.com.dio.movieslist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ao.com.dio.movieslist.R
import ao.com.dio.movieslist.domain.Movie
import coil.load
import kotlinx.android.synthetic.main.movie_items.view.*

class MovieAdapter(private val movieList: List<Movie>,private val  listener: ClickListenerMovieList) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_items, parent, false)
        return MovieViewHolder(view,listener)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.itemView.apply {
            movieTitle.text = movieList[position].titulo
            iv_movie.load(movieList[position].imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
        }

        holder.itemView.setOnClickListener {
            listener.setOnClickItemMovie(movieList[position])
        }
    }

}
