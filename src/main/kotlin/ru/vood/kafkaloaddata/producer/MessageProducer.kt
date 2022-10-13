package ru.vood.kafkaloaddata.producer

import org.springframework.context.annotation.Scope
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
@Scope("prototype")
class MessageProducer(
    private val kafkaTemplate: KafkaTemplate<String?, String>
) : MessageProducerInterface<String, String> {

    override fun sendMessage(topicName: String, key: String?, message: String) {
        kafkaTemplate.send(topicName, 1, key!!, message)
    }


}