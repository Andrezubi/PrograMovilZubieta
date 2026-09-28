package ucb.zubieta.project.PruebasGenerales.data.datasource

import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel

interface CatalogRemoteDataSource {
    suspend fun fetchData():Result<List<MovieInfoModel>>
}