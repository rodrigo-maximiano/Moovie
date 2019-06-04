package br.edu.ifsp.scl.sdm.tradutorsdmkt.retrofit

import br.edu.ifsp.scl.sdm.moovie.Constantes
import br.edu.ifsp.scl.sdm.moovie.Constantes.URL_BASE
import br.edu.ifsp.scl.sdm.moovie.MainActivity
import br.edu.ifsp.scl.sdm.moovie.model.OmdbResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.frame_main.*
import okhttp3.ResponseBody
import org.jetbrains.anko.design.snackbar
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Omdb(val mainActivity: MainActivity) {

    // Cria um objeto Retrofit usando a URL base.
    val retrofit: Retrofit = Retrofit.Builder().baseUrl(URL_BASE).build()

    // Cria um objeto, a partir da Interface Retrofit, que contém as funções de requisição
    val omdbApi: OmdbApi = retrofit.create(OmdbApi::class.java)

    fun getMovieById(id: String) {
        omdbApi.getMovieById(id, Constantes.APP_KEY_VALUE).enqueue(
            object : Callback<ResponseBody> {
                // Função chamada no caso de erro
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    mainActivity.fragmentAtivo.snackbar("Erro na resposta - Retrofit")
                }
                // Função chamada no caso de resposta
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    try {
                        // Cria um objeto Gson que consegue fazer reflexão de um Json para Data Class
                        val gson: Gson = Gson()
                        // Reflete a resposta (que é um Json) num objeto da classe Resposta
                        val resposta: OmdbResponse = gson.fromJson(response.body()?.string(), OmdbResponse::class.java)
                        // Enviando as tradução ao Handler da thread de UI para serem mostrados na tela
                        mainActivity.tradutoHandler.obtainMessage(
                            MainActivity.codigosMensagen.RESPOSTA_TRADUCAO, resposta).sendToTarget()
                    } catch (jse: JSONException) {
                        mainActivity.fragmentAtivo.snackbar("Erro na resposta - Retrofit")
                    }
                }
            }
        )
    }

    fun getMovieByTitle(title: String) {
        omdbApi.getMovieByTitle(title, Constantes.APP_KEY_VALUE).enqueue(
            object : Callback<ResponseBody> {
                // Função chamada no caso de erro
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    mainActivity.fragmentAtivo.snackbar("Erro na resposta - Retrofit")
                }
                // Função chamada no caso de resposta
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    try {
                        // Cria um objeto Gson que consegue fazer reflexão de um Json para Data Class
                        val gson: Gson = Gson()
                        // Reflete a resposta (que é um Json) num objeto da classe Resposta
                        val resposta: OmdbResponse = gson.fromJson(response.body()?.string(), OmdbResponse::class.java)
                        // Enviando as tradução ao Handler da thread de UI para serem mostrados na tela
                        mainActivity.tradutoHandler.obtainMessage(
                            MainActivity.codigosMensagen.RESPOSTA_TRADUCAO, resposta).sendToTarget()
                    } catch (jse: JSONException) {
                        mainActivity.fragmentAtivo.snackbar("Erro na resposta - Retrofit")
                    }
                }
            }
        )
    }

}