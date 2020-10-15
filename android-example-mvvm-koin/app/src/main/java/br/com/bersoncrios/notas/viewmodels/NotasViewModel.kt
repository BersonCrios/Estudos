package br.com.bersoncrios.notas.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.bersoncrios.notas.data.DataBase
import br.com.bersoncrios.notas.data.GestorDeNotas
import br.com.bersoncrios.notas.data.Nota

class NotasViewModel(val gestorNotas: GestorDeNotas): ViewModel() {

    private var mNotas: MutableLiveData<MutableList<Nota>>? = null

    fun getNotas(): LiveData<MutableList<Nota>> {
        if (mNotas == null){
            mNotas = gestorNotas.getNotas()
        }
        return  mNotas!!
    }

    fun salvar (mNota: Nota){
        gestorNotas.addNota(mNota)
    }
}