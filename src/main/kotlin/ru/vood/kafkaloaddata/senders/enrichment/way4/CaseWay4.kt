package ru.vood.kafkaloaddata.senders.enrichment.way4

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class CaseWay4(
    val dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto: dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto,
    val dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto: dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto,
    val dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto: dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto.loadTopic()
            dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto.loadTopic()
            dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto.loadTopic()
        }
    }
}