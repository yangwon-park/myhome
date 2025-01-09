dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.flywaydb:flyway-database-postgresql")
	implementation("org.postgresql:postgresql")
}

tasks.named("bootJar") {
	enabled = false
}

tasks.named("jar") {
	enabled = true
}