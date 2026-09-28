package ucb.zubieta.project.ExamenClima.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClimateDto (
    val latitude: Double? = null,
    val longitude: Double? = null,

    @SerialName("current_weather")
    val currentWeather: CurrentWeatherDto? = null
)