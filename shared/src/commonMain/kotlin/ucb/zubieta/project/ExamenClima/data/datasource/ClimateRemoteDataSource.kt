package ucb.zubieta.project.ExamenClima.data.datasource

import ucb.zubieta.project.ExamenClima.domain.model.ClimateModel
import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel


interface ClimateRemoteDataSource {
    suspend fun fetchData(
        latitude: Double,
        longitude: Double
    ): Result<ClimateModel>
}