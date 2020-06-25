package com.github.ashishkujoy

import org.gradle.api.tasks.Delete

open class CleanIntegrationTestEnvironment : Delete() {
    init {
        listOf(
                "build/classes/kotlin/integrationTest",
                "build/kotlin/compileIntegrationTestKotlin",
                "build/reports/tests/integrationTest",
                "build/resources/integrationTest",
                "build/test-results/integrationTest"
        ).forEach { delete.add(it) }
    }
}