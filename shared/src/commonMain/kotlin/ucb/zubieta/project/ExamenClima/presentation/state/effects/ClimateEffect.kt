package ucb.zubieta.project.ExamenClima.presentation.state.effects

import ucb.zubieta.project.ExamenClima.presentation.state.events.ClimateEvent

interface ClimateEffect {
    data class ShowToast(val message: String) : ClimateEffect
    object ShowClimate: ClimateEffect
    data class ShowError(val message: String): ClimateEffect
}