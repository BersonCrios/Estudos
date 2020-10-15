package br.com.bersoncrios.notas.data

class GestorDeNotas(val database: DataBase){

    fun getNotas() = database.obterNotas()

    fun addNota(mNota: Nota){
      database.inserirNota(mNota)
    }
}