plugins {
    java
    id("me.champeau.jmh") version "0.6.6"
}

group = "org.corpnet"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("commons-io:commons-io:2.11.0")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    jmh("org.openjdk.jmh:jmh-core:1.34")
    jmh("org.openjdk.jmh:jmh-generator-annprocess:1.34")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}