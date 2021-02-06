import io.github.muth0mi.checki.buildsrc.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(io.github.muth0mi.checki.buildsrc.Cheki.compileSdkVersion)
    buildToolsVersion(io.github.muth0mi.checki.buildsrc.Cheki.buildToolsVersion)
    defaultConfig {
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
}

dependencies {
    implementation(Libs.AndroidX.Lifecycle.livedata)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
}