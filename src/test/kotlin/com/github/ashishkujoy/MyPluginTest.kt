package com.github.ashishkujoy

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import org.gradle.testfixtures.ProjectBuilder

class EchoPluginTest : FunSpec({
    test("plugin should register integrationTest task") {
        val project = ProjectBuilder.builder().build()
        applyPlugins(project)

        val integrationTestTask = project.tasks.findByName("integrationTest")

        integrationTestTask.shouldNotBeNull()
    }

    test("plugin should register cleanIntegrationTestEnvironment task") {
        val project = ProjectBuilder.builder().build()
        applyPlugins(project)

        val cleanIntegrationTestEnvironmentTask = project.tasks.findByName("cleanIntegrationTestEnvironment")

        cleanIntegrationTestEnvironmentTask.shouldNotBeNull()
    }

    test("plugin should register integrationTest source set") {
        val project = ProjectBuilder.builder().build()
        applyPlugins(project)

        val integrationTestSourceSet = project.sourceSetByName("integrationTest")

        integrationTestSourceSet.shouldNotBeNull()
    }
})

fun applyPlugins(project: org.gradle.api.Project) {
    project.plugins.apply("java")
    project.plugins.apply("org.jetbrains.kotlin.jvm")
    project.plugins.apply("com.github.ashishkujoy.greeting")
}
