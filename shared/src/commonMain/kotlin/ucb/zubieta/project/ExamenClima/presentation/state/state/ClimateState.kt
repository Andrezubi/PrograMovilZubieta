package ucb.zubieta.project.ExamenClima.presentation.state.state

import ucb.zubieta.project.ExamenClima.domain.model.ClimateModel

data class ClimateState(
    val latitude: String = "",
    val longitude: String = "",
    val climate: ClimateModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)