package ucb.zubieta.project.ExamenClima.domain.repository

import ucb.zubieta.project.ExamenClima.domain.model.ClimateModel
import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel

interface ClimateRepository {
    suspend fun getClimate(latitude:Double, longitude:Double):Result<ClimateModel>
}