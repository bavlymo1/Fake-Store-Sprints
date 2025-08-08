import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "2.2.0"
}

android {
    namespace = "com.example.composedemo"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.composedemo"
        minSdk = 24
        targetSdk = 36
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11 // Changed to 11
        targetCompatibility = JavaVersion.VERSION_11 // Changed to 11
    }

    buildFeatures {
        compose = true
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        // Set your desired JVM target here. It should generally match or be compatible
        // with android.compileOptions.targetCompatibility
        jvmTarget.set(JvmTarget.JVM_11) // Or JavaVersion.VERSION_23.toString()
        // You can add other Kotlin specific compiler options here if needed, e.g.,
        // freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // --- Added Dependencies for the Product App ---

    // Networking with Retrofit and OkHttp
    implementation(libs.retrofit.v290)
    implementation(libs.okhttp.v4120)

    // Retrofit Converter for Kotlinx Serialization
    // This bridges Retrofit with Kotlinx Serialization for JSON parsing.
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    // Kotlinx Serialization runtime library
    // Essential for serializing and deserializing JSON into Kotlin data classes.
    implementation(libs.kotlinx.serialization.json.v171)

    // Glide for image loading in Jetpack Compose
    // The main Glide library and its Compose integration.
    implementation(libs.glide)
    implementation(libs.compose)

    // Jetpack Compose Navigation
    // For managing navigation between different screens in your Compose app.
    implementation(libs.androidx.navigation.compose.v280beta05)

    // --- Existing Test Dependencies ---
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
