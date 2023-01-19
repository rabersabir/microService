import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    java
    jacoco
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.springdoc.openapi-gradle-plugin") version "1.6.0"
    id("org.openapi.generator") version "4.3.1"

}
group = "com.atradius.org.search"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17



configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath("org.openapitools:openapi-generator-gradle-plugin:4.3.1")
    }
}
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-contract-stub-runner:4.0.0")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.14")
    implementation("com.squareup.okhttp3:okhttp:4.5.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("com.google.code.gson:gson:2.7")
    implementation("io.gsonfire:gson-fire:1.0.1")
    implementation("javax.validation:validation-api:2.0.1.Final")


    testImplementation("junit:junit:4.12")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-test")
    testImplementation("io.cucumber:cucumber-java:7.11.0")
    testImplementation("io.cucumber:cucumber-spring:6.11.0")
    testImplementation("io.cucumber:cucumber-junit:7.11.0")
    testCompileOnly("org.projectlombok:lombok")
}

val cucumberRuntime by configurations.creating {
    extendsFrom(configurations["testImplementation"])
}

tasks.withType<Test> {
    useJUnitPlatform()
}
task("cucumber") {
    dependsOn("assemble", "compileTestJava")
    doLast {
        javaexec {
            mainClass.set("io.cucumber.core.cli.Main")
            classpath = cucumberRuntime + sourceSets.main.get().output + sourceSets.test.get().output
            // Change glue for your project package where the step definitions are.
            // And where the feature files are.
            args = listOf("--plugin", "pretty", "--glue", "com.example.feature", "src/test/resources")
            // Configure jacoco agent for the test coverage.
            val jacocoAgent = zipTree(configurations.jacocoAgent.get().singleFile)
                    .filter { it.name == "jacocoagent.jar" }
                    .singleFile
            jvmArgs = listOf("-javaagent:$jacocoAgent=destfile=$buildDir/results/jacoco/cucumber.exec,append=false")
        }
    }
}
tasks.jacocoTestReport {
    // Give jacoco the file generated with the cucumber tests for the coverage.
    executionData(files("$buildDir/jacoco/test.exec", "$buildDir/results/jacoco/cucumber.exec"))
    reports {
        xml.required.set(true)
    }
}

sourceSets.main {
    java.srcDir("$buildDir/generatedSources/src/main/java")
    resources.srcDir("$buildDir/generatedSources/src/main/resources")
}


