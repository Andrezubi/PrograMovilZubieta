package ucb.zubieta.project.ExamenClima.data.mapper

import ucb.zubieta.project.ExamenClima.data.dto.ClimateDto
import ucb.zubieta.project.ExamenClima.domain.model.ClimateModel

fun ClimateDto.toModel(): ClimateModel {
    return ClimateModel(
        latitude = latitude ?: 0.0,
        longitude = longitude ?: 0.0,
        temperature = currentWeather?.temperature ?: 0.0,
        windSpeed = currentWeather?.windspeed ?: 0.0,
        windDirection = currentWeather?.winddirection ?: 0,
        weatherCode = currentWeather?.weathercode ?: 0,
        time = currentWeather?.time ?: ""
    )
}