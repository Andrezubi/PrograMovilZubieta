package ucb.zubieta.project.PruebasGenerales.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieInfoDto(
    val title: String?=null,
    @SerialName("poster_path")
    val posterPath: String? =null,)