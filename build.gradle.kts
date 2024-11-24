plugins {
    id("java")
    id("java-library")
    id("edu.sc.seis.launch4j") version "3.0.6"
    id("io.freefair.lombok") version "8.11"
}

group = "pending.javacat.LunarQuickLaunch"
version = "1.0-SNAPSHOT"

configure(subprojects) {
    apply(plugin = "java")
    apply(plugin = "io.freefair.lombok")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains:annotations:24.0.0")
        implementation("net.java.dev.jna:jna:5.13.0")
        implementation("net.java.dev.jna:jna-platform:5.13.0")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":program"))
}

tasks {
    build {
        dependsOn("createExe")
    }

    compileJava {
        targetCompatibility = JavaVersion.VERSION_21.toString()
        sourceCompatibility = JavaVersion.VERSION_21.toString()
        options.encoding = "UTF-8"
    }
}

launch4j {
    mainClassName = "pending.javacat.LunarQuickLaunch.boot.LunarQuickLaunchBoot"
    icon = "${projectDir}/src/main/resources/logo.ico"
    bundledJrePath = "${projectDir}/src/main/resources/jdk-21.0.5+11-jre"
}
