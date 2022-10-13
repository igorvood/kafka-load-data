package ru.vood.kafkaloaddata.senders.way4

import kotlinx.coroutines.*
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

@Service
class CaseWay4Runner(
    val dev_ivr__uasp_realtime__input_converter__mortgage__dlq: dev_ivr__uasp_realtime__input_converter__mortgage__dlq,
    val dev_rto_batch_ca_customer_card_uaspdto__dlq: dev_rto_batch_ca_customer_card_uaspdto__dlq
) : CommandLineRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun run(vararg args: String?) {
        crScope.launch {

            launch { dev_ivr__uasp_realtime__input_converter__mortgage__dlq.loadTopic() }
            launch { dev_rto_batch_ca_customer_card_uaspdto__dlq.loadTopic() }
        }
    }
}