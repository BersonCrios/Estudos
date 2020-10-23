package br.com.alura.technews.ui.activity.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.repository.Resource

class ListaNoticiasViewModel(private  val repository: NoticiaRepository): ViewModel(){

    //PARA TESTE: VER QUANDO A VIEW MODEL É CRIADA
    init {
        Log.i("VIEWMODEL", "Criando ViewModel")
    }

    //PARA TESTE: VER QUNDO A VIEWMODEL É DESTRUIDA
    override fun onCleared() {
        super.onCleared()
        Log.i("VIEWMODEL", "Destruindoo ViewModel")
    }

    //IMPLEMENTAÇÕES DE FATO
    fun buscaTodos() : LiveData<Resource<List<Noticia>?>> {
        return repository.buscaTodos()
    }
}