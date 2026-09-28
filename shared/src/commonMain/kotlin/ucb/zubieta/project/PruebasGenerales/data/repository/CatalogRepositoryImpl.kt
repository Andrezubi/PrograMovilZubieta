package ucb.zubieta.project.PruebasGenerales.data.repository

import ucb.zubieta.project.PruebasGenerales.data.datasource.CatalogRemoteDataSource
import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel
import ucb.zubieta.project.PruebasGenerales.domain.repository.CatalogRepository

class CatalogRepositoryImpl(val dataSource: CatalogRemoteDataSource): CatalogRepository {

    override suspend fun getMovies(): Result<List<MovieInfoModel>> {
        return dataSource.fetchData()

    }
}