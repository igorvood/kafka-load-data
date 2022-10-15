package ru.vood.kafkaloaddata.senders.way4

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class CaseWay4(
    val dev_ivr__uasp_realtime__input_converter__mortgage__dlq: dev_ivr__uasp_realtime__input_converter__mortgage__dlq,
    val dev_rto_batch_ca_customer_card_uaspdto__dlq: dev_rto_batch_ca_customer_card_uaspdto__dlq
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {

            launch { dev_ivr__uasp_realtime__input_converter__mortgage__dlq.loadTopic() }

            launch { dev_rto_batch_ca_customer_card_uaspdto__dlq.loadTopic() }
        }
    }
}