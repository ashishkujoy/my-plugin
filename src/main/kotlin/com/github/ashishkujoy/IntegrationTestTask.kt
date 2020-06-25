package com.github.ashishkujoy

import org.gradle.api.tasks.testing.Test

open class IntegrationTestTask : Test() {
    init {
        testClassesDirs = project.sourceSetByName("integrationTest").output.classesDirs
        classpath = project.sourceSetByName("integrationTest").runtimeClasspath
    }
}