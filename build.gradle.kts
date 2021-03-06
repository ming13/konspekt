import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        plugin(Plugin.Kotlin)
        plugin(Plugin.Versions)
    }
}

apply {
    plugin(Plugin.Versions.id)
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin(Plugin.Kotlin.id)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            allWarningsAsErrors = true

            jvmTarget = "1.8"
        }
    }

    tasks.withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors() / 2

        reports.junitXml.isEnabled = false

        useJUnitPlatform {
            includeEngines("conspectus")
        }
    }
}
