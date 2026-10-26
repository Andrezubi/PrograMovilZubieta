package ucb.zubieta.project.DollarRoom.data.dto

import ucb.zubieta.project.DollarRoom.data.datasource.DollarDao
import ucb.zubieta.project.DollarRoom.data.entity.DollarEntity
import ucb.zubieta.project.DollarRoom.domain.model.DollarModel


class DollarLocalDataSource(
    val dao: DollarDao
) {
    suspend fun getList(): List<DollarModel> {
        return dao.getList().map {
            it.toModel()
        }
    }

    suspend fun insert(dollar: DollarModel) {
        dao.insert(dollar.toEntity())
    }

    private fun DollarEntity.toModel() : DollarModel {
        return DollarModel(
            official = dollarOfficial?: "",
            parallel = dollarParallel?:""
        )
    }

    private fun DollarModel.toEntity() = DollarEntity(
        dollarOfficial = "12.05",
        dollarParallel = "12.07"
    )
}