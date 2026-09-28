package ucb.zubieta.project.PruebasGenerales.domain.repository

import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel

interface CatalogRepository {
    suspend fun getMovies(): Result<List<MovieInfoModel>>
}