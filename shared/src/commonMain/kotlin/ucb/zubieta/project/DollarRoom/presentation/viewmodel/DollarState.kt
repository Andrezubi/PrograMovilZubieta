package ucb.zubieta.project.DollarRoom.presentation.viewmodel

import ucb.zubieta.project.DollarRoom.domain.model.DollarModel

data class DollarState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val list: List<DollarModel> = emptyList()
)