package br.edu.ifsp.scl.sdm.moovie.model

import java.io.Serializable

/*
    título, ano, data de lançamento, diretor, atores, idioma, país,
    notas de avaliação (fonte e valor), nota IMDb, tipo, produtora e website.
*/

data class OmdbResponse (
    val Title : String,
    val Year : Int,
    val Released : String,
    val Director : String,
    val Actors : String,
    val Language : String,
    val Country : String,
    val Poster : String,
    val Ratings : List<Ratings>,
    val imdbRating : String,
    val Type : String,
    val Production : String,
    val Website : String,
    val Response : Boolean,
    val Error : String
) : Serializable

data class Ratings (
    val Source : String,
    val Value : String
) : Serializable