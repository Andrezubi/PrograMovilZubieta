package ucb.zubieta.project.PruebasGenerales.data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header

import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ucb.zubieta.project.PruebasGenerales.data.datasource.CatalogRemoteDataSource
import ucb.zubieta.project.PruebasGenerales.data.dto.CatalogDto
import ucb.zubieta.project.PruebasGenerales.data.mapper.toModel
import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel


class CatalogService: CatalogRemoteDataSource {



    private val client = HttpClient{

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }
    override suspend fun fetchData(): Result<List<MovieInfoModel>> {
        val response = client.get("https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=fa3e844ce31744388e07fa47c7c5d8c3")
        try {
            return Result.success(response.body<CatalogDto>().results.map{it.toModel()})
        } catch (e: Exception) {
            throw e
        }
    }
}
