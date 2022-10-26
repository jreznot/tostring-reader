plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.9.0"
}

group = "org.strangeway.tsr"
version = "1.0.6"

repositories {
    mavenCentral()
}

java.sourceSets["main"].java {
    srcDir("src/main/gen")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

intellij {
    version.set("2021.3.3")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf())
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    patchPluginXml {
        sinceBuild.set("213")
        untilBuild.set("231.*")

        changeNotes.set("""
          <ul>
            <li>Support Android Studio</li>
          </ul>
        """.trimIndent())
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
