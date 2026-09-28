package ucb.zubieta.project.PruebasGenerales.presentation.state.state

import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel

data class CatalogState (
    val isLoading: Boolean = false,
    val error: String? = null,
    val movies: List<MovieInfoModel> = emptyList()
)