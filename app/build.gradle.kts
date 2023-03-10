object Constants {
    const val compose_version = "1.2.0"
}
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "online.edrh.composable"
    compileSdk = 33

    defaultConfig {
        applicationId = "online.edrh.composable"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = Constants.compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui:${Constants.compose_version}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Constants.compose_version}")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("androidx.compose.material3:material3:1.1.0-alpha04")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Constants.compose_version}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Constants.compose_version}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Constants.compose_version}")
}