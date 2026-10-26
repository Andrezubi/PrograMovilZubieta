package ucb.zubieta.project.ExamenClima.domain.model
data class ClimateModel(
    val latitude: Double,
    val longitude: Double,
    val temperature: Double,
    val windSpeed: Double,
    val windDirection: Int,
    val weatherCode: Int,
    val time: String
)