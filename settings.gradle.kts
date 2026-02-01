pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Search Air Tickets"
include(":app")
include(":feature_main")
include(":feature_bottom_sheet")
include(":feature_bottom_nav")
include(":feature_profile")
include(":feature_local")
include(":feature_hotel")
include(":feature_natification")
include(":core_database")
