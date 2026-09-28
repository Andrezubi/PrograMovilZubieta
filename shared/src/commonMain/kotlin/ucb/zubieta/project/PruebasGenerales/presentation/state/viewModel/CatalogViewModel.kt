package ucb.zubieta.project.PruebasGenerales.presentation.state.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ucb.zubieta.project.PruebasGenerales.domain.usecase.GetMoviesUseCase
import ucb.zubieta.project.PruebasGenerales.presentation.state.effects.CatalogEffect
import ucb.zubieta.project.PruebasGenerales.presentation.state.events.CatalogEvent
import ucb.zubieta.project.PruebasGenerales.presentation.state.state.CatalogState

class CatalogViewModel(val getMovies: GetMoviesUseCase): ViewModel() {
    private val _state= MutableStateFlow<CatalogState>(CatalogState())
    val state= _state.asStateFlow()

    private val _effect= MutableSharedFlow<CatalogEffect>()
    val effect =_effect.asSharedFlow()


    init{
        loadMovies()
    }
    fun loadMovies() {
        viewModelScope.launch {
            _state.update { currentState: CatalogState ->
                currentState.copy(isLoading = true, error = null)
            }

            // Call the usecase and handle the Result directly
            getMovies()
                .onSuccess { moviesList ->
                    _state.update { currentState: CatalogState ->
                        currentState.copy(
                            isLoading = false,
                            movies = moviesList
                        )
                    }
                }
                .onFailure { throwable ->
                    _state.update { currentState: CatalogState ->
                        currentState.copy(
                            isLoading = false,
                            error = throwable.message ?: "Error al cargar películas"
                        )
                    }
                    emmitEffect(CatalogEffect.ShowToast("Error: ${throwable.message}"))
                }
        }
    }

    fun emitEvent(event: CatalogEvent){
        when(event){
            is CatalogEvent.OnSubmit->{
                emmitEffect(CatalogEffect.ShowToast("Nuevo toast generado"))

            }

            CatalogEvent.OnBack->{
                emmitEffect(CatalogEffect.NavigateToBack)
            }

        }
    }
    private fun emmitEffect(effect: CatalogEffect){
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }

}