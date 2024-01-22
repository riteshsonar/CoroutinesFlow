plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")

}

android {
    namespace = "com.example.coroutinesexamples"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coroutinesexamples"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    dataBinding {
        enable = true
    }
    viewBinding { enable = true }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Retrofit and Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    // retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
// GSON
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //dagger 2
    //implementation ("com.google.dagger:dagger:2.28.3")
    //annotationProcessor ("com.google.dagger:dagger-compiler:2.25.3")
    //annotationProcessor ("com.google.dagger:dagger-android-processor:2.25.3")
    implementation ("com.google.dagger:dagger:2.17")
    kapt ("com.google.dagger:dagger-compiler:2.17")
    //room

    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")
    annotationProcessor ("android.arch.persistence.room:compiler:1.1.1")

    //Biometric Auth
    implementation("androidx.biometric:biometric:1.1.0")





}