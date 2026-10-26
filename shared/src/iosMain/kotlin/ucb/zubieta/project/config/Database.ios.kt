package ucb.zubieta.project.config

import androidx.room3.RoomDatabaseConstructor

@Suppress("KotlinNoActualForExpect")
actual object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    actual override fun initialize(): AppDatabase {
        error("Not implemented for iOS")
    }
}
