package ucb.zubieta.project

import android.app.Application
import ucb.zubieta.project.di.initKoinAndroid

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid(this)
    }
}
