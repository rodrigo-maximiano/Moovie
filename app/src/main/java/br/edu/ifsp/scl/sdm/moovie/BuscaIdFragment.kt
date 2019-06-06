package br.edu.ifsp.scl.sdm.moovie

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.scl.sdm.tradutorsdmkt.retrofit.Omdb
import kotlinx.android.synthetic.main.fragment_buscar_id.*
import kotlinx.android.synthetic.main.toolbar.*

class BuscaIdFragment: ModoBuscaFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutFragment = inflater.inflate(R.layout.fragment_buscar_id, null)
        activity?.toolbar?.subtitle = "Busca por Id"
        return layoutFragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnBuscarPorId.setOnClickListener{ buscarFilme(it) }
    }

    override fun buscarFilme(view: View) {
        val omdb = Omdb(mainActivity!!)
        omdb.getMovieById(edtIdFilme.text.toString())
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

}