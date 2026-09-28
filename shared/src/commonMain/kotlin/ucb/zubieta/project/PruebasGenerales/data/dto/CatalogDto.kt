package ucb.zubieta.project.PruebasGenerales.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatalogDto (
    val page: Int?=0,
    val results: List<MovieInfoDto>,)