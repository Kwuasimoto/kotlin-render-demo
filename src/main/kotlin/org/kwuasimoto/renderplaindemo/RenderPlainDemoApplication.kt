package org.kwuasimoto.renderplaindemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RenderPlainDemoApplication

fun main(args: Array<String>) {
    print("Hello World")
    runApplication<RenderPlainDemoApplication>(*args)
}
