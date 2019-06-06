package br.edu.ifsp.scl.sdm.moovie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.edu.ifsp.scl.sdm.moovie.model.OmdbResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val movie = intent.extras.getSerializable("movie") as OmdbResponse
        showMovieData(movie)
    }

    private fun showMovieData(movie: OmdbResponse) {
        txvTitulo.text = movie.Title
        txvAno.text = movie.Year
        txvLancamento.text = movie.Released
        txvDiretor.text = movie.Director
        txvAtores.text = movie.Actors
        txvIdioma.text = movie.Language
        txvPais.text = movie.Country
        txvNotaImdb.text = movie.imdbRating
        txvTipo.text = movie.Type
        txvProdutora.text = movie.Production
        txvWebsite.text = movie.Website
        //seta a lista das notas de avaliação
        lstNotasAvaliacao.adapter = RatingsAdapter(this, movie.Ratings)
        //carrega a imagem do pôster do filme no imageView
        Picasso.get().load(movie.Poster).into(imgPoster)
    }
}
