package br.edu.ifsp.scl.sdm.moovie

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.edu.ifsp.scl.sdm.moovie.model.OmdbResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.design.snackbar
//import org.jetbrains.anko.startActivity
import java.util.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instancia o handler da thread de UI usado pelos Fragments
        messageHandler = MessageHandler()

        setSupportActionBar(toolbar)
        supportActionBar?.title = resources.getString(R.string.app_name)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val abreFechaToggle: ActionBarDrawerToggle =
                ActionBarDrawerToggle(this,
                        menuLateralDrawerLayout,
                        toolbar,
                        R.string.menu_aberto,
                        R.string.menu_fechado
                )
        menuLateralDrawerLayout.addDrawerListener(abreFechaToggle)
        abreFechaToggle.syncState()

        menuNavigationView.setNavigationItemSelectedListener { onNavigationItemSelected(it) }
    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        var retorno: Boolean = false
        when(item.itemId){
            R.id.buscaIdMenuItem -> {
                substituiFragment("id")
                retorno = true
            }
            R.id.buscaTituloMenuItem -> {
                substituiFragment("title")
                retorno = true
            }
            R.id.sairMenuItem -> {
                finish()
                retorno = true
            }
        }
        menuLateralDrawerLayout.closeDrawer(GravityCompat.START)
        return retorno
    }

    private fun substituiFragment(modo: String) {
        val modoBuscaFragment = if(modo == "id") BuscaIdFragment() else BuscaTituloFragment()

        // Transaction para substituição de fragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentAtivo,  modoBuscaFragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if(menuLateralDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            menuLateralDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    lateinit var messageHandler: MessageHandler

    inner class MessageHandler: Handler() {
        override fun handleMessage(msg: Message?) {
            // Pega o retorno da chamada do serviço
            val response = msg?.obj as OmdbResponse
            if(response.Response) {
                callResultActivity(response)
            } else {
                Toast.makeText(this@MainActivity, response.Error, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun callResultActivity(movie: OmdbResponse) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }

}