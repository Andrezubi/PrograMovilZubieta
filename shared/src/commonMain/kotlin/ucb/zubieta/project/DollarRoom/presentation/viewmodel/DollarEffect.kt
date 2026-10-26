package ucb.zubieta.project.DollarRoom.presentation.viewmodel


interface DollarEffect {
    data class ShowToast(val message: String): DollarEffect
}