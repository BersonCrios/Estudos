package br.com.bersoncrios.starwarsapp.data.repository

import br.com.bersoncrios.starwarsapp.data.api.ApiHelper

class MainRepository (private val apiHelper: ApiHelper){

    suspend fun getPeoples() = apiHelper.getPeoples()

}