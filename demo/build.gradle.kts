import io.github.muth0mi.cheki.buildsrc.Libs
import io.github.muth0mi.cheki.buildsrc.Cheki

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Cheki.compileSdkVersion)
    buildToolsVersion(Cheki.buildToolsVersion)
    defaultConfig {
        applicationId = "io.github.muth0mi.cheki"
        minSdkVersion(Cheki.minSdkVersion)
        targetSdkVersion(Cheki.targetSdkVersion)
        testInstrumentationRunner = Cheki.testInstrumentationRunner
        versionCode = 1
        versionName = "0.0.1"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
        kotlinCompilerVersion = Libs.Kotlin.version
    }
}

dependencies {
    implementation(project(":cheki"))
    implementation(Libs.Coroutines.android)
    implementation(Libs.material)
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.Lifecycle.viewmodel)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.runtimeLivedata)
    implementation(Libs.AndroidX.Compose.tooling)
    implementation(Libs.AndroidX.Navigation.composeNavigation)
    implementation(Libs.AndroidX.Room.runtime)
    implementation(Libs.AndroidX.Room.ktx)
    implementation(Libs.Accompanist.insets)
    implementation(Libs.AndroidX.Hilt.lifecycle)
    implementation(Libs.Hilt.hilt)

    kapt(Libs.AndroidX.Room.compiler)
    kapt(Libs.AndroidX.Hilt.compiler)
    kapt(Libs.Hilt.compiler)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
}
