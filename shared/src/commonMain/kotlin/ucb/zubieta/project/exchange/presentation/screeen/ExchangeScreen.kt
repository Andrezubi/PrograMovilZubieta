package ucb.zubieta.project.exchange.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import edu.ucb.ds.shared.generated.resources.Res
import edu.ucb.ds.shared.generated.resources.login_title
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ucb.zubieta.project.exchange.presentation.viewmodel.ExchangeViewModel



@Composable
fun ExchangeScreen(viewModel: ExchangeViewModel = koinViewModel()) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val message = viewModel.message.collectAsState()
        Text(message.value)
        MainButton(stringResource(Res.string.login_title)) {
            print("Press")
        }
    }

}

@Composable
fun MainButton(x0: String, content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}