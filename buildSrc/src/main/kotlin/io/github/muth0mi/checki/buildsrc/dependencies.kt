package io.github.muth0mi.checki.buildsrc

object Cheki {
    const val targetSdkVersion = 30
    const val compileSdkVersion = targetSdkVersion
    const val minSdkVersion = 21
    const val buildToolsVersion = "30.0.3"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Libs {
    const val junit = "junit:junit:4.13"

    const val material = "com.google.android.material:material:1.1.0"

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"

        object Compose {
            const val version = "1.0.0-alpha09"
            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
        }

        object Test {
            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"

            object Ext {
                private const val version = "1.1.2-rc01"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }
        }

        object Lifecycle {
            private const val version = "2.2.0"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        }
    }
}