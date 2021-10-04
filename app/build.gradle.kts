plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(AppConfig.javaVersion)
        targetCompatibility(AppConfig.javaVersion)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        android.buildFeatures.viewBinding = true
    }
}

dependencies {

    implementation(project(":historyScreenModule"))
    implementation(project(":storage"))
    implementation(project(":domainModule"))

    implementation(Kotlin.coreKtx)
    implementation(Kotlin.stdlib)

    implementation(Design.appcompat)
    implementation(Design.constraintLayout)
    implementation(Design.material)

    implementation(Koin.core)
    implementation(Koin.compat)
    implementation(Koin.android)

    implementation(Coroutines.core)
    implementation(Coroutines.adapter)
    implementation(Coroutines.android)

    implementation(Cicerone.cicerone)

    implementation(Test.junit)
    androidTestImplementation(Test.extJunit)
    androidTestImplementation(Test.espresso)
}