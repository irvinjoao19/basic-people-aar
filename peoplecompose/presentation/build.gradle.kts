plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id("maven-publish")
}

val publishArtifact = artifacts.add("default", file("libs/presentation-release.aar"))

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("presentation-aar") {
                groupId = "com.bcp.sdk.product"
                artifactId = "peoplecompose.presentation"
                version = "1.1.1"
                artifact(publishArtifact)
//                from(components["java"])

                pom.withXml {

                    val dependenciesNode = asNode().appendNode("dependencies")
                    configurations["implementation"].allDependencies.forEach { dependency ->
                        dependency.group?.let { group ->
                            if (group.startsWith("androidx") || group.startsWith("android.arch.navigation")) {
                                val dependencyNode = dependenciesNode.appendNode("dependency")
                                dependencyNode.appendNode("groupId", dependency.group)
                                dependencyNode.appendNode("artifactId", dependency.name)
                                dependencyNode.appendNode("version", dependency.version)
                            }
                        }
                    }
                }
            }
        }
    }
}


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

dependencies {
    implementation(project(":peoplecompose:data"))
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
}