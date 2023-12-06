pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "basic-people-aar"
include(":app")
include(
    ":peoplecompose:data",
    ":peoplecompose:domain",
    ":peoplecompose:presentation"
)