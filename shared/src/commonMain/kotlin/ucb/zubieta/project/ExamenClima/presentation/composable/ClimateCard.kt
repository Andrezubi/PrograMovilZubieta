package ucb.zubieta.project.ExamenClima.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ucb.zubieta.project.ExamenClima.domain.model.ClimateModel

@Composable
fun ClimateCard(
    climate: ClimateModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = "Clima actual",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "${climate.temperature} °C",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            ClimateInfoRow(
                label = "Velocidad del viento",
                value = "${climate.windSpeed} km/h"
            )

            ClimateInfoRow(
                label = "Dirección del viento",
                value = "${climate.windDirection}°"
            )

            ClimateInfoRow(
                label = "Código climático",
                value = climate.weatherCode.toString()
            )

            ClimateInfoRow(
                label = "Hora",
                value = climate.time
            )

            ClimateInfoRow(
                label = "Latitud",
                value = climate.latitude.toString()
            )

            ClimateInfoRow(
                label = "Longitud",
                value = climate.longitude.toString()
            )
        }
    }
}