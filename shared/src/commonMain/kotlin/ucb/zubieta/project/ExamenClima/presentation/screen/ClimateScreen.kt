package ucb.zubieta.project.ExamenClima.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import ucb.zubieta.project.ExamenClima.presentation.composable.ClimateCard
import ucb.zubieta.project.ExamenClima.presentation.state.effects.ClimateEffect
import ucb.zubieta.project.ExamenClima.presentation.state.events.ClimateEvent
import ucb.zubieta.project.ExamenClima.presentation.state.viewModel.ClimateViewModel

@Composable
fun ClimateScreen(
    viewModel: ClimateViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is ClimateEffect.ShowToast -> {
                    println("TOAST: ${effect.message}")
                }

                is ClimateEffect.ShowError -> {
                    println("ERROR: ${effect.message}")
                }

                ClimateEffect.ShowClimate -> {
                    println("Climate loaded")
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Consulta del clima",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = state.latitude,
            onValueChange = { value ->
                viewModel.emitEvent(
                    ClimateEvent.OnLatitudeChange(value)
                )
            },
            label = {
                Text("Latitud")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = state.longitude,
            onValueChange = { value ->
                viewModel.emitEvent(
                    ClimateEvent.OnLongitudeChange(value)
                )
            },
            label = {
                Text("Longitud")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {
                viewModel.emitEvent(
                    ClimateEvent.OnSubmit
                )
            }
        ) {
            Text("Consultar clima")
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        state.error?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }

        state.climate?.let { climate ->
            ClimateCard(climate)
        }
    }
}