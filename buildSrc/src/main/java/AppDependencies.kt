
object Kotlin {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxLibVersion}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatLibVersion}"
    const val material = "com.google.android.material:material:${Versions.materialLibVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutLibVersion}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerviewLibVersion}"
    const val kirichDelegate = "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewBindingLibVersion}"
    const val kirichNoreflection = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBindingLibVersion}"
}

object Retrofit {
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingLibVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitLibVersion}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitLibVersion}"
}

object Koin {
    const val core = "io.insert-koin:koin-core:${Versions.koinLibVersion}"
    const val android = "io.insert-koin:koin-android:${Versions.koinLibVersion}"
    const val compat = "io.insert-koin:koin-android-compat:${Versions.koinLibVersion}"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesLibVersion}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesLibVersion}"
    const val adapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesAdapterLibVersion}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.roomLibVersion}"
    const val ktx = "androidx.room:room-ktx:${Versions.roomLibVersion}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomLibVersion}"
}

object Cicerone {
    const val cicerone = "com.github.terrakok:cicerone:${Versions.ciceroneLibVersion}"
}

object Test {
    const val junit = "junit:junit:${Versions.junitLibVersion}"
    const val extJunit = "androidx.test.ext:junit:${Versions.junitLibVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCoreLiVersion}"
}