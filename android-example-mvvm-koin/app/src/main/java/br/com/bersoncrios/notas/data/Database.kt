package br.com.bersoncrios.notas.data

import androidx.lifecycle.MutableLiveData

class DataBase {

    private val mDatabase: MutableLiveData<MutableList<Nota>> =  MutableLiveData()


    fun inserirNota(nota: Nota) {
        var tmp = mDatabase.value
        if(tmp == null) {
            tmp = mutableListOf()
            tmp.add(nota)
        }
        else{
            tmp?.add(nota)
        }
        mDatabase.postValue(tmp)
    }
    fun obterNotas() = mDatabase
}