package ucb.zubieta.project.ExamenClima.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    val temperature: Double? = null,
    val windspeed: Double? = null,
    val winddirection: Int? = null,
    val weathercode: Int? = null,
    val time: String? = null

)