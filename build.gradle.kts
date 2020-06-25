plugins {
    `java-gradle-plugin`
    `kotlin-dsl-base`
    java
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
    id("maven-publish")
}

group = "com.github.ashishkujoy.greeting"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_11


repositories {
    mavenCentral()
}

publishing {
    repositories {
        maven {
            url = uri("$buildDir/repo")
        }
    }
}

dependencies {
    val kotestVersion = "4.1.0"
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.1.0")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-runner-console-jvm:$kotestVersion")
}

gradlePlugin {
    val greeting by plugins.creating {
        id = "com.github.ashishkujoy.greeting"
        implementationClass = "com.github.ashishkujoy.MyPlugin"
        version = version
    }
}
