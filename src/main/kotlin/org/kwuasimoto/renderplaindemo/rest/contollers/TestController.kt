package org.kwuasimoto.renderplaindemo.rest.contollers

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class DataRequest(
    val payload: String
)

data class DataResponse(
    val payload: String
)

@RestController
@RequestMapping("/test")
class TestController {

    private val logger = LoggerFactory.getLogger(TestController::class.java)

    @GetMapping
    fun helloWorld(request: HttpServletRequest): ResponseEntity<DataResponse> {
        logger.info("Incoming fetch request")
        logger.info("$request")
        return ResponseEntity.ok(DataResponse(payload = "Hello World"))
    }

    @PostMapping
    fun postData(@RequestBody incoming: DataRequest, request: HttpServletRequest): ResponseEntity<*> {
        logger.info("Incoming post request")
        logger.info("$request")
        return ResponseEntity.ok(incoming)
    }
}