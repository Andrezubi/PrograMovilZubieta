import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import dev.detekt.gradle.Detekt


plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.detekt)
    id("io.sentry.android.gradle") version "6.22.0"
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
}
detekt {
    source.setFrom(
        "src/commonMain/kotlin",
        "src/androidMain/kotlin",
        "src/iosMain/kotlin"
    )
    config.setFrom(files("${rootDir}/config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
    ignoreFailures = false
}

tasks.withType<Detekt>().configureEach {
    include("**/*.kt", "**/*.kts")
    exclude("**/build/**")
}

tasks.register<Detekt>("detektAll") {
    description = "Analiza todo el código fuente KMP"
    group = "verification"

    // Incluye todo el directorio src del módulo
    setSource(files("src"))
    include("**/*.kt", "**/*.kts")
    exclude("**/build/**")

    reports {
        html.required.set(true)
        sarif.required.set(true)
    }
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    android {
       namespace = "ucb.zubieta.project.shared"
       compileSdk = libs.versions.android.compileSdk.get().toInt()
       minSdk = libs.versions.android.minSdk.get().toInt()

       compilerOptions {
           jvmTarget = JvmTarget.JVM_11
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
       withDeviceTestBuilder {
           sourceSetTreeName = "test"
       }.configure {
           instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
       }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.compose.uiTooling)

            // Android-specific Ktor engine belongs here
            implementation(libs.ktor.client.okhttp)
        }

        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation("io.sentry:sentry-kotlin-multiplatform:0.10.0")

            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)

            // Core Ktor dependencies belong here for ALL platforms
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.navigation.compose)
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        iosMain.dependencies {
            // iOS-specific Ktor engine belongs here
            implementation(libs.ktor.client.darwin)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}