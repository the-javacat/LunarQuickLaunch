plugins {
    id("java")
    id("edu.sc.seis.launch4j") version "3.0.6"
}

group = "pending.javacat"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
    implementation("net.java.dev.jna:jna:5.13.0")
    implementation("net.java.dev.jna:jna-platform:5.13.0")
}

launch4j {
    mainClassName = "pending.javacat.boot.LunarQuickLaunchBoot"
    icon = "${projectDir}/src/main/resources/logo.ico"
    bundledJrePath = "${projectDir}/src/main/resources/temurin-23.0.1"
}