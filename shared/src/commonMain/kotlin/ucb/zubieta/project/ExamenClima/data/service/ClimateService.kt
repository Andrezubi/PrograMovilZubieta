package ucb.zubieta.project.ExamenClima.data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ucb.zubieta.project.ExamenClima.data.datasource.ClimateRemoteDataSource
import ucb.zubieta.project.ExamenClima.data.dto.ClimateDto
import ucb.zubieta.project.ExamenClima.data.mapper.toModel
import ucb.zubieta.project.ExamenClima.domain.model.ClimateModel

class ClimateService : ClimateRemoteDataSource {

    private val client = HttpClient {
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

    override suspend fun fetchData(
        latitude: Double,
        longitude: Double
    ): Result<ClimateModel> {

        return try {
            val response = client.get(
                "https://api.open-meteo.com/v1/forecast" +
                        "?latitude=$latitude" +
                        "&longitude=$longitude" +
                        "&current_weather=true"
            )

            Result.success(
                response.body<ClimateDto>().toModel()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}