import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import java.io.ByteArrayOutputStream

plugins {
    val kotlinVersion = "1.6.21"
    java
    groovy
    kotlin("jvm") version (kotlinVersion)
}

group = "playground"
version = "0.0.0"

sourceSets {
    getByName("test"){
        java.srcDir("src/scripts/groovy")
    }
    getByName("test"){
        java.srcDir("src/scripts/kscript")
    }
    getByName("test"){
        java.srcDir("src/test/javascript")
    }
}


dependencies {
    // Kotlin lib: jdk8, reflexion, coroutines
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    //miscellaneous
    implementation("commons-io:commons-io:${properties["commons_io_version"]}")
    implementation("org.apache.commons:commons-lang3:${properties["commons_lang3_version"]}")
    // Kotlin test lib
    testImplementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${properties["kotlinx_coroutines_version"]}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:${properties["kotlinx_coroutines_version"]}")
    // Groovy
    testImplementation("org.codehaus.groovy:groovy-all:${properties["groovy_version"]}")
    // Logger
    testImplementation("ch.qos.logback:logback-classic:${properties["logback_version"]}")
    testImplementation("ch.qos.logback:logback-classic:${properties["logback_version"]}")
    // TDD
    testImplementation(platform("org.junit:junit-bom:${properties["junit_version"]}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:${properties["assertj_version"]}")
    // kotlin TDD
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    // ProjectReactor.io
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${properties["reactor_kotlin_coroutines_version"]}")
    testImplementation("io.projectreactor.kotlin:reactor-kotlin-extensions:${properties["reactor_kotlin_version"]}")
    testImplementation("io.projectreactor:reactor-test:${properties["reactor_version"]}")
    testImplementation(kotlin("script-runtime"))

    // Arrow.kt
    testImplementation(platform("io.arrow-kt:arrow-stack:1.0.1"))
    testImplementation("io.arrow-kt:arrow-core")

}

gradle.startParameter.isContinueOnFailure = true

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging { events(PASSED, SKIPPED, FAILED) }
    testLogging.showStandardStreams = true
//    systemProperties(java.lang.System.getProperties())
}

// config JVM target to 1.8 for kotlin compilation tasks
//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
//    kotlinOptions.jvmTarget = properties["jvm_target"] as String
//}


open class PrintHerokuVersion : Exec() {
    init {
        this.workingDir = project.rootDir
        this.commandLine("/snap/bin/heroku", "-v")
        this.standardOutput = ByteArrayOutputStream()
    }
}

project.tasks.register<PrintHerokuVersion>("printHerokuVersion")

project.tasks.withType<PrintHerokuVersion> {
    doLast { logger.info(standardOutput.toString()) }
}
