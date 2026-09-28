package ucb.zubieta.project.di
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ucb.zubieta.project.ExamenClima.presentation.state.viewModel.ClimateViewModel
import ucb.zubieta.project.PruebasGenerales.presentation.state.viewModel.CatalogViewModel

val presentationModule = module {
    viewModelOf(::CatalogViewModel)
    viewModelOf(::ClimateViewModel)


}
