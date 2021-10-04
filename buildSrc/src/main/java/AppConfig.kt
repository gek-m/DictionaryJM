import org.gradle.api.JavaVersion

object AppConfig {
    const val applicationId = "com.example.dictionaryjm"
    const val compileSdk = 30
    const val minSdk = 26
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0"
    const val buildToolsVersion = "30.0.3"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    val javaVersion = JavaVersion.VERSION_1_8
}