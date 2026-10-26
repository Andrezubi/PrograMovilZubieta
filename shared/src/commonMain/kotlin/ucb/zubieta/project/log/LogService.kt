package ucb.zubieta.project.log

expect class LogService(serverUrl: String) {
    suspend fun sendLogs(request: com.develoop.logs.LogRequest): com.develoop.logs.LogResponse
}