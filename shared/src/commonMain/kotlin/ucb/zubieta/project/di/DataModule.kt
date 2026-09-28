package ucb.zubieta.project.di

import androidx.compose.foundation.layout.Box
import org.koin.dsl.module
import ucb.zubieta.project.ExamenClima.data.datasource.ClimateRemoteDataSource
import ucb.zubieta.project.ExamenClima.data.repository.ClimateRepositoryImpl
import ucb.zubieta.project.ExamenClima.data.service.ClimateService
import ucb.zubieta.project.ExamenClima.domain.repository.ClimateRepository
import ucb.zubieta.project.PruebasGenerales.data.datasource.CatalogRemoteDataSource
import ucb.zubieta.project.PruebasGenerales.data.repository.CatalogRepositoryImpl
import ucb.zubieta.project.PruebasGenerales.data.service.CatalogService
import ucb.zubieta.project.PruebasGenerales.domain.repository.CatalogRepository

val dataModule = module {

        single<CatalogRemoteDataSource> { CatalogService() }
        single<CatalogRepository>{ CatalogRepositoryImpl(get()) }

        single<ClimateRemoteDataSource>{ ClimateService() }
        single<ClimateRepository>{ ClimateRepositoryImpl(get()) }

}
