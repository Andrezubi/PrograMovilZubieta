package ucb.zubieta.project.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ucb.zubieta.project.config.AppDatabase
import ucb.zubieta.project.config.getDatabaseBuilder

actual fun platformModule(): Module = module {
    single<AppDatabase> {
        getDatabaseBuilder(get()).build()
    }
}