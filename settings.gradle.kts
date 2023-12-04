pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "basic-people-aar"
include(":app")
include(
    ":peoplecompose:data",
    ":peoplecompose:domain",
    ":peoplecompose:presentation"
)