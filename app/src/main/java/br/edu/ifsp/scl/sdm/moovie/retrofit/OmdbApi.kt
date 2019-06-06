package br.edu.ifsp.scl.sdm.tradutorsdmkt.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface OmdbApi {

    //As anotações dos parâmetros da função descrevem o mapeamento para parâmetros do Path da requisição. */
    @GET("/")
    fun getMovieById(@Query("apikey") apikey: String, @Query("i") id: String): Call<ResponseBody>

    @GET("/")
    fun getMovieByTitle(@Query("apikey") apikey: String, @Query("t") title: String): Call<ResponseBody>

}