package ru.vood.kafkaloaddata.config.prop

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "send.kafka.cnt")
data class CountProperties(
        val userCnt: Int,
        val totalSendRecCnt: Int
)
