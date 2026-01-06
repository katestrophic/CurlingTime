group = "katestrophic"
version = "0.1.0"

plugins {
    java
    application
    id("org.javamodularity.moduleplugin") version "1.8.15"
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("org.beryx.jlink") version "2.25.0"
}

repositories {
    mavenCentral()
}

application {
    mainModule.set("katestrophic.curlingtime")
    mainClass.set("katestrophic.curlingtime.Launcher")
}
dependencies {
    implementation("com.mysql:mysql-connector-j:9.5.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.12.1")
}
jlink {
    imageZip.set(layout.buildDirectory.file("/distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    launcher {
        name = "CurlingTime"
    }
}

// LANGUAGE
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
javafx {
    version = "21.0.6"
    modules = listOf("javafx.controls", "javafx.fxml")
}

// TASKS
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
tasks.withType<Test> {
    useJUnitPlatform()
}
