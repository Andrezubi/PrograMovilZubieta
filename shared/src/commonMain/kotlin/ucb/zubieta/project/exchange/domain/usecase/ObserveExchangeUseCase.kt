package ucb.zubieta.project.exchange.domain.usecase
import kotlinx.coroutines.flow.Flow
import ucb.zubieta.project.exchange.domain.repository.ExchangeRepository

class ObserveExchangeUseCase(
    val repository: ExchangeRepository
) {
    suspend fun invoke(): Flow<String?> {
        return repository.observe()
    }
}