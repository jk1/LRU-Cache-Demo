plugins {
    kotlin("jvm") version "2.0.21"
}

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}