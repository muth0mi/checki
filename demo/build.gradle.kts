import io.github.muth0mi.checki.buildsrc.Libs
import io.github.muth0mi.checki.buildsrc.Cheki

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(io.github.muth0mi.checki.buildsrc.Cheki.compileSdkVersion)
    buildToolsVersion(io.github.muth0mi.checki.buildsrc.Cheki.buildToolsVersion)
    defaultConfig {
        applicationId = "io.github.muth0mi.cheki"
        minSdkVersion(io.github.muth0mi.checki.buildsrc.Cheki.minSdkVersion)
        targetSdkVersion(io.github.muth0mi.checki.buildsrc.Cheki.targetSdkVersion)
        testInstrumentationRunner = io.github.muth0mi.checki.buildsrc.Cheki.testInstrumentationRunner
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
        kotlinCompilerExtensionVersion = io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Compose.version
        kotlinCompilerVersion = io.github.muth0mi.checki.buildsrc.Libs.Kotlin.version
    }
}

dependencies {
    implementation(project(":checki"))
    implementation(io.github.muth0mi.checki.buildsrc.Libs.Coroutines.android)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.material)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.coreKtx)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.appcompat)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Lifecycle.viewmodel)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Compose.ui)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Compose.material)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Compose.runtimeLivedata)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Compose.tooling)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Navigation.composeNavigation)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Room.runtime)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Room.ktx)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.Accompanist.insets)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Hilt.lifecycle)
    implementation(io.github.muth0mi.checki.buildsrc.Libs.Hilt.hilt)

    kapt(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Room.compiler)
    kapt(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Hilt.compiler)
    kapt(io.github.muth0mi.checki.buildsrc.Libs.Hilt.compiler)

    testImplementation(io.github.muth0mi.checki.buildsrc.Libs.junit)
    androidTestImplementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Test.espressoCore)
}
