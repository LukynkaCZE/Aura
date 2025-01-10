plugins {
    kotlin("jvm")
}

group = "cz.lukynka"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://mvn.devos.one/releases")
}

dependencies {
    api("org.reflections:reflections:0.9.12")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("com.akuleshov7:ktoml-core:0.5.1")
    implementation("com.akuleshov7:ktoml-file:0.5.1")
    api("cz.lukynka:pretty-log:1.4")
    api("it.unimi.dsi:fastutil:8.5.13")
    api("cz.lukynka:kotlin-bindables:1.2")

    testImplementation(kotlin("test"))
    testImplementation("org.mockito:mockito-core:5.4.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}