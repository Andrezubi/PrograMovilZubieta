package ucb.zubieta.project.exchange.data.repository


import kotlinx.coroutines.flow.Flow
import ucb.zubieta.project.exchange.data.datasource.RealTimeDataBase
import ucb.zubieta.project.exchange.domain.repository.ExchangeRepository

class ExchangeRepositoryImpl(
    val realTimeDataBase: RealTimeDataBase
): ExchangeRepository {
    override suspend fun observe(): Flow<String?> {
        return realTimeDataBase.observeMessage()
    }
}