package br.com.bersoncrios.starwarsapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.bersoncrios.starwarsapp.data.repository.MainRepository
import br.com.bersoncrios.starwarsapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel (private val mainRepository: MainRepository): ViewModel(){

    fun getPeoples() = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getPeoples().results))
        } catch (ex: Exception) {
            emit(Resource.error(data = null, message = ex.message ?: "Error Ocurred!"))
            Log.e("AAAAAA", ex.message.toString())
        }
    }
}