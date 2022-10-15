package ru.vood.kafkaloaddata.config.prop

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "send.kafka.cnt")
data class CountProperties(
    var userCnt: Int=0,
    var totalSendRecCnt: Int=0
)
