package ucb.zubieta.project.DollarRoom.presentation.viewmodel

sealed interface DollarEvent {
    object OnAddRecord: DollarEvent
}