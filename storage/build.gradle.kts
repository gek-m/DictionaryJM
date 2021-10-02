plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android{
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas")
            }
        }
    }
    compileOptions {
        sourceCompatibility(AppConfig.javaVersion)
        targetCompatibility(AppConfig.javaVersion)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domainModule"))

    implementation(Room.runtime)
    implementation(Room.ktx)
    kapt(Room.compiler)

    implementation(Koin.core)
    implementation(Koin.compat)
    implementation(Koin.android)
}