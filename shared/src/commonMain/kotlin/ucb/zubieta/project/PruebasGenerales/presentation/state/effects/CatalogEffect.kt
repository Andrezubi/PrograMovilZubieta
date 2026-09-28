package ucb.zubieta.project.PruebasGenerales.presentation.state.effects


sealed interface  CatalogEffect {
    data class ShowToast(val message: String): CatalogEffect
    data object NavigateToBack : CatalogEffect
}