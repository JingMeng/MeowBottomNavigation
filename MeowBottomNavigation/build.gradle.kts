import meow.AppConfig
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("android")
}

group = AppConfig.Publishing.groupId
version = AppConfig.generateVersionName()

android {
    namespace = "com.etebarian.meowbottomnavigation"
    compileSdk = AppConfig.Versions.SDK_COMPILE
    defaultConfig {
        minSdk = AppConfig.Versions.SDK_MIN
        targetSdk = AppConfig.Versions.SDK_TARGET
    }
    buildFeatures { dataBinding = true }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    sourceSets.getByName("main") {
        java.srcDirs("src/main/kotlin")
        res.srcDirs(meow.getAllResourcesSrcDirs(project, true))
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    AppConfig.Dependencies.implementationItems.forEach { implementation(it) }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}
