package org.kwuasimoto.renderplaindemo.rest.contollers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping
    fun helloWorld(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello World")
    }

}