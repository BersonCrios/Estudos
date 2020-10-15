package br.com.bersoncrios.starwarsapp.data.api

class ApiHelper  (private val apiService: ApiService){

    suspend fun getPeoples() = apiService.getPeoples()

}