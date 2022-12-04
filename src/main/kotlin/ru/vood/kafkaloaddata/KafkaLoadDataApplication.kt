package ru.vood.kafkaloaddata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class KafkaLoadDataApplication

fun main(args: Array<String>) {
    runApplication<KafkaLoadDataApplication>(*args)
}
