package com.github.ashishkujoy

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.kotlin.dsl.withConvention
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

class MyPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        setIntegrationTestSourceSet(project)

        val cleanIntegrationTestEnvironment = project.tasks.register("cleanIntegrationTestEnvironment", CleanIntegrationTestEnvironment::class.java) {
            group = "joy"
        }
        val integrationTest = project.tasks.register("integrationTest", IntegrationTestTask::class.java) {
            group = "joy"
            dependsOn(cleanIntegrationTestEnvironment)
        }
    }

    private fun setIntegrationTestSourceSet(project: Project) {
        with(project) {
            val sourceSets = sourceSets()
            sourceSets.create("integrationTest") {
                withConvention(KotlinSourceSet::class) {
                    kotlin.srcDir("src/integrationTest/kotlin")
                    compileClasspath += sourceSets.main().output + sourceSets.test().output + configurations.getByName("testRuntimeClasspath")
                    runtimeClasspath += output + compileClasspath + configurations.getByName("testRuntimeClasspath")
                }
                resources.srcDir("src/integrationTest/resources")
            }
        }
    }
}
