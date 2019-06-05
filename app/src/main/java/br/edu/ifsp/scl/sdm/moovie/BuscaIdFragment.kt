package br.edu.ifsp.scl.sdm.moovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.`fragment-buscar-id`.*
import kotlinx.android.synthetic.main.toolbar.*

class BuscaIdFragment: ModoBuscaFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutFragment = inflater.inflate(R.layout.fragment_buscar_id, null)
        activity?.toolbar?.subtitle = "Busca por Id"
        return layoutFragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        jogarDadoButton.setOnClickListener{ buscarFilme(it) }
    }

    override fun buscarFilme(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}