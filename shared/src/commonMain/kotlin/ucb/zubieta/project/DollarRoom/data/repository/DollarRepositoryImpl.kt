package ucb.zubieta.project.DollarRoom.data.repository

import ucb.zubieta.project.DollarRoom.data.dto.DollarLocalDataSource
import ucb.zubieta.project.DollarRoom.domain.model.DollarModel
import ucb.zubieta.project.DollarRoom.domain.repository.DollarRepository


class DollarRepositoryImpl(
    val localDataSource: DollarLocalDataSource
): DollarRepository {
    override suspend fun getList(): List<DollarModel> {
        return localDataSource.getList()
    }

    override suspend fun insert(dollar: DollarModel) {
        localDataSource.insert(dollar)
    }
}