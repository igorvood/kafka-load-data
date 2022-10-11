package ru.vood.kafkaloaddata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaLoadDataApplication

fun main(args: Array<String>) {
    runApplication<KafkaLoadDataApplication>(*args)
}
