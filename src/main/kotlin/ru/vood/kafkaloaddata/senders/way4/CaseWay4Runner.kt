package ru.vood.kafkaloaddata.senders.way4

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

@Service
class CaseWay4Runner(
    val dev_ivr__uasp_realtime__input_converter__mortgage__dlq: dev_ivr__uasp_realtime__input_converter__mortgage__dlq
): CommandLineRunner {

    override fun run(vararg args: String?) {
        dev_ivr__uasp_realtime__input_converter__mortgage__dlq.loadTopic()
    }
}