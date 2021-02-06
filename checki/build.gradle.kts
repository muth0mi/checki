import io.github.muth0mi.checki.buildsrc.Libs
import io.github.muth0mi.checki.buildsrc.Cheki

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

//apply plugin: 'com.novoda.bintray-release'
//
//publish {
//
//    groupId = 'com.github.jumadeveloper'
//    artifactId = 'networkmanager'
//    publishVersion = '0.0.2'
//    desc = 'A library to check various types of network connections, to allow an app check internet connectivity status before making HTTP Requests.'
//    licences = ['Apache-2.0']
//    repoName = 'network-manager'
//    website = 'https://github.com/jumadeveloper/AndroidNetworkManager'
//}

dependencies {
    implementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Lifecycle.livedata)

    testImplementation(io.github.muth0mi.checki.buildsrc.Libs.junit)
    androidTestImplementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(io.github.muth0mi.checki.buildsrc.Libs.AndroidX.Test.espressoCore)
}
