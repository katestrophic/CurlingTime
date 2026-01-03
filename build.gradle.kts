group = "katestrophic"
version = "1.0.0"

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
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")

    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
jlink {
    imageZip.set(layout.buildDirectory.file("/distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    launcher {
        name = "Curling Time"
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
tasks.withType<JavaExec> {
    jvmArgs = listOf(
        "--add-modules", "javafx.controls,javafx.fxml"
    )
}
tasks.withType<Test> {
    useJUnitPlatform()
}
