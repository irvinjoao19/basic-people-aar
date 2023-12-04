plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id("maven-publish")
}


configurations.maybeCreate("default")
val publishArtifact = artifacts.add("default", file("people-presentation-2.1.1.aar"))

publishing {
    publications {
        create<MavenPublication>("aar") {
            groupId = "com.bcp.sdk.product"
            artifactId = "peoplecompose.presentation"
            version = "1.0.0"
            artifact(publishArtifact)
        }
    }
}

//
//afterEvaluate {
//    publishing {
//        publications {
//            // Creates a Maven publication called "release".
//            release(MavenPublication) {
//                // Applies the component for the release build variant.
//                from components.release
//
//                        // You can then customize attributes of the publication as shown below.
//                        groupId = 'com.example.MyLibrary'
//                artifactId = 'final'
//                version = '1.0'
//            }
//            // Creates a Maven publication called “debug”.
//            debug(MavenPublication) {
//                // Applies the component for the debug build variant.
//                from components.debug
//
//                        groupId = 'com.example.MyLibrary'
//                artifactId = 'final-debug'
//                version = '1.0'
//            }
//        }
//    }
//}

android {
    namespace = "com.bcp.sdk.product.peoplecompose.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    viewBinding {
        enable = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":peoplecompose:domain"))

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")

    //Picasso
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("jp.wasabeef:picasso-transformations:2.4.0")

    //Shimmer
    implementation("com.facebook.shimmer:shimmer:0.5.0")

    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}