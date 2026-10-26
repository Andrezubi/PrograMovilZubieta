package ucb.zubieta.project.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ucb.zubieta.project.ExamenClima.domain.usecase.GetClimateUseCase
import ucb.zubieta.project.PruebasGenerales.domain.usecase.GetMoviesUseCase
import ucb.zubieta.project.exchange.domain.usecase.ObserveExchangeUseCase
val domainModule = module {
    singleOf(::GetMoviesUseCase)
    singleOf(::GetClimateUseCase)
    singleOf(::ObserveExchangeUseCase)
}
