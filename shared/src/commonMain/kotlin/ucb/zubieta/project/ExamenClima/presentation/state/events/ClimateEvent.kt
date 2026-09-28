package ucb.zubieta.project.ExamenClima.presentation.state.events

interface ClimateEvent {
    data class OnLatitudeChange(val latitude: String): ClimateEvent
    data class OnLongitudeChange(val longitude: String): ClimateEvent
    object OnSubmit: ClimateEvent
}