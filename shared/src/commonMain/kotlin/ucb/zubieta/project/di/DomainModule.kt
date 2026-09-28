package ucb.zubieta.project.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ucb.zubieta.project.PruebasGenerales.domain.usecase.GetMoviesUseCase

val domainModule = module {
    singleOf(::GetMoviesUseCase)
}
