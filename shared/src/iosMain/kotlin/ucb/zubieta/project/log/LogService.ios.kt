package ucb.zubieta.project.log

import com.develoop.logs.LogRequest
import com.develoop.logs.LogResponse

actual class LogService actual constructor(
    serverUrl: String
) {
    actual suspend fun sendLogs(
        request: LogRequest
    ): LogResponse {
        error("Not implemented for iOS")
    }
}
