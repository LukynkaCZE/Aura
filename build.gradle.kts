plugins {
    kotlin("jvm") version "1.9.23"
}

group = "cz.lukynka"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}