package ru.vood.kafkaloaddata.senders.case55

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner
import ru.vood.kafkaloaddata.senders.enrichment.way4.dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto
import ru.vood.kafkaloaddata.senders.enrichment.way4.dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto

@Service
class Case55(
    val dev__pp_fl_uasp__opyp: dev__pp_fl_uasp__opyp,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { dev__pp_fl_uasp__opyp.loadTopic() }
        }
    }
}