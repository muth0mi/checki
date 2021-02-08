import io.github.muth0mi.checki.buildsrc.Cheki
import io.github.muth0mi.checki.buildsrc.Libs

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
        testInstrumentationRunner =
            Cheki.testInstrumentationRunner
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
    }
}

dependencies {
    implementation("com.github.muth0mi:checki:0.0.1")
    implementation(Libs.material)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.runtimeLivedata)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
}
