plugins {
    java
}

group = "org.example"
version = "1.1"


buildscript {
    repositories {
        mavenCentral()
    }
}

dependencies {

}

repositories {
    mavenCentral()
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "docsOpener.Main"
    }

    from(configurations
        .runtimeClasspath
        .get()
        .files
        .map { if (it.isDirectory) it else zipTree(it) })
}

