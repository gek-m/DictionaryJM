import java.util.Properties

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }
    compileOptions {
        sourceCompatibility(AppConfig.javaVersion)
        targetCompatibility(AppConfig.javaVersion)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes.forEach {
        val properties = Properties()
        properties.load(project.rootProject.file("app.properties").inputStream())
        val apiKey = properties.getProperty("api_key", "")
        it.buildConfigField("String", "API_KEY", apiKey)
        val apiUrl = properties.getProperty("api_url", "https://dictionary.yandex.net")
        it.buildConfigField("String", "API_URL", apiUrl)
    }
}

dependencies {
    implementation(Retrofit.retrofit)
    implementation(Retrofit.interceptor)
    implementation(Retrofit.gson)

    implementation(Room.runtime)
    implementation(Room.ktx)
    kapt(Room.compiler)

    implementation(Coroutines.core)
    implementation(Coroutines.adapter)
    implementation(Coroutines.android)

    implementation(Koin.core)
    implementation(Koin.compat)
    implementation(Koin.android)
}