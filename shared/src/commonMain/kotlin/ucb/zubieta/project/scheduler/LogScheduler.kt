package ucb.zubieta.project.scheduler

expect class LogScheduler(context: Any?) {
    fun schedulePeriodicalUpload()
}