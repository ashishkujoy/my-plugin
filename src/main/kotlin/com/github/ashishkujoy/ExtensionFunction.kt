package com.github.ashishkujoy

import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer

fun Project.sourceSets(): SourceSetContainer = convention.getPlugin(JavaPluginConvention::class.java).sourceSets
fun Project.sourceSetByName(sourceSetName: String): SourceSet = sourceSets().getByName(sourceSetName)
fun SourceSetContainer.main(): SourceSet = getByName("main")
fun SourceSetContainer.test(): SourceSet = getByName("test")
