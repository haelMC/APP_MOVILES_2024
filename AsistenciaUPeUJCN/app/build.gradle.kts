plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt") //Agregado
    id("dagger.hilt.android.plugin") //Agregado
}

android {
    namespace = "pe.edu.upeu.asistenciaupeujcn"
    compileSdk = 34

    defaultConfig {
        applicationId = "pe.edu.upeu.asistenciaupeujcn"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true"
                )
                // arguments += ["room.schemaLocation":
                //"$projectDir/schemas".toString()]
            }
        }

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//Navegacion
    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-compose:$nav_version")
//Agregados Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.52") //old 2.47
    kapt ("com.google.dagger:hilt-compiler:2.52") //old 2.47
//Agregado Dagger - Hilt Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0") //old 1.0.0
    implementation("com.valentinilk.shimmer:compose-shimmer:1.3.1") //old 1.0.5
    implementation ("io.coil-kt:coil-compose:2.7.0") //old 2.4.0
//Agregado LiveData compose//implementation ("androidx.compose.ui:ui-tooling")
    implementation ("androidx.compose.foundation:foundation")
    implementation ("androidx.compose.runtime:runtime-livedata")
//Formularios
    implementation ("com.github.k0shk0sh:compose-easyforms:0.2.0")
// Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
//App Compact para detectar modo dia noche
    val appcompat_version = "1.7.0" //old 1.6.1
    implementation("androidx.appcompat:appcompat:$appcompat_version")//Agregado recien

//Room
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
// To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
// optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
//Manager permissions
    implementation ("com.google.accompanist:accompanist-permissions:0.30.1")
//Corrutinas
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
//Location
    implementation ("com.google.android.gms:play-services-location:21.0.1")

    //Para trabajar con camara
    val camerax_version = "1.5.0-alpha01" //1.2.3
    implementation ("androidx.camera:camera-core:${camerax_version}")
    implementation ("androidx.camera:camera-camera2:${camerax_version}")
    implementation ("androidx.camera:camera-lifecycle:${camerax_version}")
    implementation ("androidx.camera:camera-view:${camerax_version}")
    implementation ("com.google.mlkit:barcode-scanning:17.3.0")
}