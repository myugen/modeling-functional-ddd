package dev.myugen.ordertaking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrderTakingApplication

fun main(args: Array<String>) {
    runApplication<OrderTakingApplication>(*args)
}