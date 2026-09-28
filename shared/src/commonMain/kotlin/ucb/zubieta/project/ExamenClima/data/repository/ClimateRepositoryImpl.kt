package ucb.zubieta.project.ExamenClima.data.repository

import ucb.zubieta.project.ExamenClima.data.datasource.ClimateRemoteDataSource
import ucb.zubieta.project.ExamenClima.domain.model.ClimateModel
import ucb.zubieta.project.ExamenClima.domain.repository.ClimateRepository
import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel

class ClimateRepositoryImpl(val dataSource: ClimateRemoteDataSource): ClimateRepository {
    override suspend fun getClimate(latitude: Double,longitude: Double): Result<ClimateModel> {
        return dataSource.fetchData(latitude,longitude)
    }
}