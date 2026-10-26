package ucb.zubieta.project

import android.app.Application
import ucb.zubieta.project.di.initKoinAndroid

import ucb.zubieta.project.scheduler.LogScheduler
class MainApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid(this)

        val logScheduler = LogScheduler(this)
        logScheduler.schedulePeriodicalUpload()
    }
}
