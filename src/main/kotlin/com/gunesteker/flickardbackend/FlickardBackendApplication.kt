package com.gunesteker.flickardbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlickardBackendApplication

fun main(args: Array<String>) {
    runApplication<FlickardBackendApplication>(*args)
}
