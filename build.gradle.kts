import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.ByteArrayOutputStream

//import java.lang.System.getProperties

plugins {
    val kotlinVersion = "1.6.0"
    java
    groovy
    kotlin("jvm") version (kotlinVersion)
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap/") }
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:${properties["groovy_version"]}")
    // Logger
    testImplementation("ch.qos.logback:logback-classic:${properties["logback_version"]}")
    implementation("ch.qos.logback:logback-classic:${properties["logback_version"]}")
    //Kotlin lib: jdk8, reflexion, coroutines
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${properties["kotlinx_coroutines_version"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:${properties["kotlinx_coroutines_version"]}")
    // TDD
    testImplementation(platform("org.junit:junit-bom:${properties["junit_version"]}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:${properties["assertj_version"]}")
    // kotlin TDD
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    // ProjectReactor.io
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${properties["coroutines_kotlin_reactor"]}")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:${properties["reactor_kotlin_version"]}")
    testImplementation("io.projectreactor:reactor-test:${properties["reactor_version"]}")
    //miscellaneous
    implementation("commons-io:commons-io:${properties["commons_io_version"]}")
    implementation("org.apache.commons:commons-lang3:${properties["commons_lang3_version"]}")
}

gradle.startParameter.isContinueOnFailure = true

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging { events(PASSED, SKIPPED, FAILED) }
    testLogging.showStandardStreams = true
//    systemProperties(System.getProperties())
}

// config JVM target to 1.8 for kotlin compilation tasks
//tasks.withType<KotlinCompile>().configureEach {
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
