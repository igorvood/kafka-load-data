package ru.vood.kafkaloaddata.config.prop

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring.kafka")
data class CountProperties(
    val userCnt: Int,
    val totalSendRecCnt: Int
)
