package br.com.bersoncrios.starwarsapp.di

import br.com.bersoncrios.starwarsapp.data.api.ApiHelper
import br.com.bersoncrios.starwarsapp.data.api.ApiService
import br.com.bersoncrios.starwarsapp.ui.base.ViewModelFactory
import br.com.bersoncrios.starwarsapp.ui.main.adapter.MainAdapter
import br.com.bersoncrios.starwarsapp.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DependencyModule {
    val dependencyModule = module {
        single { ApiHelper(get()) }
        factory { ViewModelFactory(get()) }
        viewModel { MainViewModel(get()) }
    }
}