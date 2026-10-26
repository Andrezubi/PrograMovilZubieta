package ucb.zubieta.project.ExamenClima.presentation.state.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ucb.zubieta.project.ExamenClima.domain.usecase.GetClimateUseCase
import ucb.zubieta.project.ExamenClima.presentation.state.effects.ClimateEffect
import ucb.zubieta.project.ExamenClima.presentation.state.events.ClimateEvent
import ucb.zubieta.project.ExamenClima.presentation.state.state.ClimateState

class ClimateViewModel(
private val getClimate: GetClimateUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ClimateState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<ClimateEffect>()
    val effect = _effect.asSharedFlow()

    fun emitEvent(event: ClimateEvent) {
        when (event) {

            is ClimateEvent.OnLatitudeChange -> {
                _state.update {
                    it.copy(
                        latitude = event.latitude,
                        error = null
                    )
                }
            }

            is ClimateEvent.OnLongitudeChange -> {
                _state.update {
                    it.copy(
                        longitude = event.longitude,
                        error = null
                    )
                }
            }

            ClimateEvent.OnSubmit -> {
                loadClimate()
            }
        }
    }

    private fun loadClimate() {

        val latitude = state.value.latitude.toDoubleOrNull()
        val longitude = state.value.longitude.toDoubleOrNull()

        if (latitude == null) {
            showError("Ingrese una latitud válida")
            return
        }

        if (latitude !in -90.0..90.0) {
            showError("La latitud debe estar entre -90 y 90")
            return
        }

        if (longitude == null) {
            showError("Ingrese una longitud válida")
            return
        }

        if (longitude !in -180.0..180.0) {
            showError("La longitud debe estar entre -180 y 180")
            return
        }

        viewModelScope.launch {

            _state.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            getClimate(
                latitude = latitude,
                longitude = longitude
            )
                .onSuccess { climate ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            climate = climate
                        )
                    }

                    emitEffect(
                        ClimateEffect.ShowClimate
                    )
                }
                .onFailure { exception ->

                    val message =
                        exception.message ?: "Error al obtener el clima"

                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = message
                        )
                    }

                    emitEffect(
                        ClimateEffect.ShowError(message)
                    )
                }
        }
    }

    private fun showError(message: String) {
        _state.update {
            it.copy(
                error = message
            )
        }

        emitEffect(
            ClimateEffect.ShowError(message)
        )
    }

    private fun emitEffect(effect: ClimateEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }
}