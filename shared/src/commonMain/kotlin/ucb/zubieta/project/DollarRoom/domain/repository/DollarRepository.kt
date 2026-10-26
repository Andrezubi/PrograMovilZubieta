package ucb.zubieta.project.DollarRoom.domain.repository

import ucb.zubieta.project.DollarRoom.domain.model.DollarModel

interface DollarRepository {
    suspend fun getList(): List<DollarModel>

    suspend fun insert(dollar: DollarModel)
}