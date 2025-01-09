package com.myhome.controller

import mu.KotlinLogging
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val log = KotlinLogging.logger {}

@RestController
@RequestMapping("/api")
class InitController(
	private val env: Environment,
) {
	@GetMapping
	fun init(): String {
		val activeProfiles = env.activeProfiles.joinToString(", ")
		val propertyValue = env.getProperty("spring.jpa.open-in-view")
		val propertyValue2 = env.getProperty("spring.datasource.password")
		val propertyValue3 = env.getProperty("spring.flyway.locations")

		log.info { "active profiles: $activeProfiles" }
		log.info { "propertyValue: $propertyValue" }
		log.info { "propertyValue: $propertyValue2" }
		log.info { "propertyValue2: $propertyValue3" }

		return "ok"
	}
}