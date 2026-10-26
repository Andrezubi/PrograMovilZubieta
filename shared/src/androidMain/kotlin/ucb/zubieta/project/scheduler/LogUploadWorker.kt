package ucb.zubieta.project.scheduler

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ucb.zubieta.project.exchange.domain.usecase.ObserveExchangeUseCase
import kotlin.getValue

class LogUploadWorker(
    appContext: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(appContext, workerParameters), KoinComponent {

    private val alias: ObserveExchangeUseCase by inject()

    override suspend fun doWork(): Result {
        println("ejecutar instrucción para subir datos")
        val response = alias.invoke()
        return Result.success()
    }
}