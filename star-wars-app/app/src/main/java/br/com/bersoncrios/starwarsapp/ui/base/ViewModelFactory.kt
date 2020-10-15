package br.com.bersoncrios.starwarsapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.bersoncrios.starwarsapp.data.api.ApiHelper
import br.com.bersoncrios.starwarsapp.data.repository.MainRepository
import br.com.bersoncrios.starwarsapp.ui.main.viewmodel.MainViewModel

class ViewModelFactory (private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }


}