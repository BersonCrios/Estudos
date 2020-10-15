package br.com.bersoncrios.starwarsapp.data.api

import br.com.bersoncrios.starwarsapp.data.model.People
import retrofit2.http.GET

interface ApiService {

    @GET("people")
    suspend fun getPeoples(): People

}