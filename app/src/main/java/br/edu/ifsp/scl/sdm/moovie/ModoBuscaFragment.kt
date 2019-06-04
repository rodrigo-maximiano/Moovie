package br.edu.ifsp.scl.sdm.moovie

import android.support.v4.app.Fragment
import android.view.View
import java.util.*

abstract class ModoBuscaFragment: Fragment  (){

    // Metodo abstrato para jogar o dado
    abstract fun buscarFilme(view: View)

}