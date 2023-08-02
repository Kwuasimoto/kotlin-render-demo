package org.kwuasimoto.renderplaindemo.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfigurationSource
import kotlin.jvm.Throws

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration(
    private val corsConfigurationSource: CorsConfigurationSource
) {

    @Throws(Exception::class)
    @Bean
    protected fun configureWebSecurity(http: HttpSecurity): SecurityFilterChain {

        http.anonymous { it.disable() }
        http.csrf { it.disable() }
        http.formLogin { it.disable() }
        http.httpBasic { it.disable() }
        http.logout { it.disable() }
        http.headers { it.xssProtection { } }
        http.cors { it.configurationSource(corsConfigurationSource) }

        http.sessionManagement {
            it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            it.sessionFixation()
            it.maximumSessions(1)
        }

        http.authorizeHttpRequests {
            it.requestMatchers("/**")
                .permitAll()
                .anyRequest().authenticated()
        }

        return http.build()
    }
}