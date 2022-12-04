package ru.vood.kafkaloaddata.senders.tracer

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class CaseTracer (
    val dev_ivr__uasp_realtime__mdm_enrichment__for_additional_enrichment__uaspdto_tracer: dev_ivr__uasp_realtime__mdm_enrichment__for_additional_enrichment__uaspdto_tracer,
    val dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto_tracer: dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto_tracer,
    val dev_rto_batch_ca_deposit_account_case_71_json_converted: dev_rto_batch_ca_deposit_account_case_71_json_converted,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { dev_ivr__uasp_realtime__mdm_enrichment__for_additional_enrichment__uaspdto_tracer.loadTopic() }
//            launch { dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto_tracer.loadTopic() }
            launch { dev_rto_batch_ca_deposit_account_case_71_json_converted.loadTopic() }
        }
    }
}