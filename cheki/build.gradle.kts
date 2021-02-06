import io.github.muth0mi.cheki.buildsrc.Libs
import io.github.muth0mi.cheki.buildsrc.Cheki

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
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
}
