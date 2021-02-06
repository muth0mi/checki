import io.github.muth0mi.checki.buildsrc.Cheki
import io.github.muth0mi.checki.buildsrc.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(Cheki.compileSdkVersion)
    buildToolsVersion(Cheki.buildToolsVersion)
    defaultConfig {
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
}

dependencies {
    implementation(Libs.AndroidX.Lifecycle.livedata)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
}