package org.kwuasimoto.renderplaindemo

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class RenderPlainDemoApplication
private val logger = LoggerFactory.getLogger(RenderPlainDemoApplication::class.java)

private fun determineEnvironment(): String {
    return when (System.getenv("APP_ENV") ?: "dev") {
        "prod" -> "prod"
        else -> "dev"
    }
}

fun main(args: Array<String>) {
    val runningEnvironment = determineEnvironment()
    logger.info("Running environment: [env=$runningEnvironment]")
    logger.info("SPRING_JPA_DATASOURCE_URL: [url=${System.getenv("SPRING_JPA_DATASOURCE_URL")}]")
    System.setProperty("spring.profiles.active", runningEnvironment)
    runApplication<RenderPlainDemoApplication>(*args)
}
