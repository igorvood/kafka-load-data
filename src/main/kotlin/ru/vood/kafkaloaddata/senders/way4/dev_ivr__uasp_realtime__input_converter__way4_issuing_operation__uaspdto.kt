package ru.vood.kafkaloaddata.senders.way4

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kafka.tools.kafkautil.producer.MessageProducer
import ru.vood.kafka.tools.kafkautil.producer.MessageProducerInterface

@Service
class dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto(
    val messageProducer: MessageProducer
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        while (true) {

        }
    }
}