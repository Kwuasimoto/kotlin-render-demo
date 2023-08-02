package org.kwuasimoto.renderplaindemo.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class Cors {

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        val urlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()

        corsConfiguration.allowCredentials = true
        corsConfiguration.allowedOrigins = listOf("https://solidjs-render-demo.onrender.com", "http://localhost:10000")
        corsConfiguration.allowedMethods = listOf("GET", "POST", "OPTIONS")
        corsConfiguration.allowedHeaders = listOf("Origin", "Content-Type", "Accept", "Authorization", "X-CSRF-TOKEN",
            "Access-Control-Request-Method", "Access-Control-Request-Headers", "Access-Control-Allow-Origin")

        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)
        return urlBasedCorsConfigurationSource
    }

}