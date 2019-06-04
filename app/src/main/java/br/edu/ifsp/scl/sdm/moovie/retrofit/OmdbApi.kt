package br.edu.ifsp.scl.sdm.tradutorsdmkt.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface OmdbApi {

    //As anotações dos parâmetros da função descrevem o mapeamento para parâmetros do Path da requisição. */
    @GET
    fun getMovieById(@Path("apikey") apikey: String, @Path("i") id: String): Call<ResponseBody>

    @GET
    fun getMovieByTitle(@Path("apikey") apikey: String, @Path("t") title: String): Call<ResponseBody>

}