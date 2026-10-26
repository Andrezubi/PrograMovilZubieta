package ucb.zubieta.project.di

import androidx.compose.foundation.layout.Box
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ucb.zubieta.project.DollarRoom.data.datasource.DollarDao
import ucb.zubieta.project.DollarRoom.data.dto.DollarLocalDataSource
import ucb.zubieta.project.DollarRoom.data.repository.DollarRepositoryImpl
import ucb.zubieta.project.DollarRoom.domain.repository.DollarRepository
import ucb.zubieta.project.ExamenClima.data.datasource.ClimateRemoteDataSource
import ucb.zubieta.project.ExamenClima.data.repository.ClimateRepositoryImpl
import ucb.zubieta.project.ExamenClima.data.service.ClimateService
import ucb.zubieta.project.ExamenClima.domain.repository.ClimateRepository
import ucb.zubieta.project.PruebasGenerales.data.datasource.CatalogRemoteDataSource
import ucb.zubieta.project.PruebasGenerales.data.repository.CatalogRepositoryImpl
import ucb.zubieta.project.PruebasGenerales.data.service.CatalogService
import ucb.zubieta.project.PruebasGenerales.domain.repository.CatalogRepository
import ucb.zubieta.project.config.AppDatabase
import ucb.zubieta.project.exchange.data.datasource.RealTimeDataBase
import ucb.zubieta.project.exchange.data.repository.ExchangeRepositoryImpl
import ucb.zubieta.project.exchange.domain.repository.ExchangeRepository
val dataModule = module {

        single<CatalogRemoteDataSource> { CatalogService() }
        single<CatalogRepository>{ CatalogRepositoryImpl(get()) }

        single<ClimateRemoteDataSource>{ ClimateService() }
        single<ClimateRepository>{ ClimateRepositoryImpl(get()) }
        singleOf(::RealTimeDataBase)
        single<ExchangeRepository> { ExchangeRepositoryImpl(get()) }



        single<DollarDao> {
                get<AppDatabase>().getDao()
        }
        singleOf(::DollarLocalDataSource)
        single<DollarRepository> { DollarRepositoryImpl(get()) }
}
