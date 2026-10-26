package ucb.zubieta.project.DollarRoom.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

import ucb.zubieta.project.DollarRoom.domain.model.DollarModel
import ucb.zubieta.project.DollarRoom.domain.repository.DollarRepository

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.compose.viewmodel.koinViewModel
import ucb.zubieta.project.DollarRoom.presentation.viewmodel.DollarViewModel
import ucb.zubieta.project.DollarRoom.presentation.viewmodel.DollarEvent


@Composable
fun DollarScreen(
    viewModel: DollarViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsState()
    Column {
        Button(onClick = {
            viewModel.emitEvent(DollarEvent.OnAddRecord)
        }) {
            Text("Add")
        }
        Text(state.value.list.size.toString())
    }

}