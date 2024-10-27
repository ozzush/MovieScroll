pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        fun PluginResolveDetails.useVersionFromGradleProperty(propertyName: String) {
            gradle.rootProject.extra[propertyName]?.let { useVersion(it as String) }
        }
        eachPlugin {
            val pluginId = requested.id.id
            when {
                pluginId.startsWith("org.jetbrains.kotlin") -> useVersionFromGradleProperty("kotlin_version")
                pluginId == "io.ktor.plugin" -> useVersionFromGradleProperty("ktor_version")
                pluginId == "org.jetbrains.compose" -> useVersionFromGradleProperty("compose_version")
                pluginId == "com.android.application" -> useVersionFromGradleProperty("android_application_version")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":server")
include(":movie-scroll-android")
include(":movie-scroll-desktop")
