import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
	kotlin("plugin.serialization") version "1.9.22"
}

group = "com.learning.asteroid"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json")
	implementation("org.apache.httpcomponents:httpclient:4.5.13")
	implementation("co.elastic.clients:elasticsearch-java:8.13.0")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
	implementation("com.fasterxml.jackson.core:jackson-core:2.17.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
