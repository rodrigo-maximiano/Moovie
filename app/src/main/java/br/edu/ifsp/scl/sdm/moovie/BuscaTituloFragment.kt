package br.edu.ifsp.scl.sdm.moovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.scl.sdm.tradutorsdmkt.retrofit.Omdb
import kotlinx.android.synthetic.main.fragment_buscar_titulo.*
import kotlinx.android.synthetic.main.toolbar.*

class BuscaTituloFragment: ModoBuscaFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutFragment = inflater.inflate(R.layout.fragment_buscar_titulo, null)
        activity?.toolbar?.subtitle = "Busca por Título"
        return layoutFragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnBuscarPorTitulo.setOnClickListener{ buscarFilme(it) }
    }

    override fun buscarFilme(view: View) {
        val omdb = Omdb(MainActivity())
        omdb.getMovieByTitle(edtTituloFilme.text.toString())
    }

}