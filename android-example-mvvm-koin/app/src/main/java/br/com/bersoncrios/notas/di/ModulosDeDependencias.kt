package br.com.bersoncrios.notas.di

import br.com.bersoncrios.notas.data.DataBase
import br.com.bersoncrios.notas.data.GestorDeNotas
import br.com.bersoncrios.notas.viewmodels.NotasViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ModulosDeDependencias {
    val moduloDaApp = module {
        single { DataBase() }
        factory { GestorDeNotas(get()) }
        viewModel { NotasViewModel(get()) }
    }
}