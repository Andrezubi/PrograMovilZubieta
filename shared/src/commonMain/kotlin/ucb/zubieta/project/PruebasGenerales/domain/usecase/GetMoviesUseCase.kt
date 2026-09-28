package ucb.zubieta.project.PruebasGenerales.domain.usecase

import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel
import ucb.zubieta.project.PruebasGenerales.domain.repository.CatalogRepository

class GetMoviesUseCase(private val repository: CatalogRepository) {
    suspend operator fun invoke (): Result<List<MovieInfoModel>>{
        return repository.getMovies()
    }
}