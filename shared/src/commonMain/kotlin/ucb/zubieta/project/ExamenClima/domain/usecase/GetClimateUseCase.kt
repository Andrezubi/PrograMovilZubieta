package ucb.zubieta.project.ExamenClima.domain.usecase

import ucb.zubieta.project.ExamenClima.domain.model.ClimateModel
import ucb.zubieta.project.ExamenClima.domain.repository.ClimateRepository
import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel
import ucb.zubieta.project.PruebasGenerales.domain.repository.CatalogRepository

class GetClimateUseCase(private val repository: ClimateRepository) {
    suspend operator  fun invoke (latitude:Double, longitude: Double):Result<ClimateModel>{
        return repository.getClimate(latitude,longitude)
    }
}