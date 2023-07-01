plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.14.2"
}

group = "org.strangeway.tsr"
version = "1.1.0"

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
    version.set("2023.1.3")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf())
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    patchPluginXml {
        sinceBuild.set("231")
        untilBuild.set("241.*")

        changeNotes.set("""
          <ul>
            <li>Support IntelliJ IDEA 2023.1</li>
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
