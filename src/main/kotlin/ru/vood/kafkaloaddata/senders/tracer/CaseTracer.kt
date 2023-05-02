package ru.vood.kafkaloaddata.senders.tracer

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class CaseTracer(
        val dev_bevents__realtime__case_71__uaspdto_tracer: dev_bevents__realtime__case_71__uaspdto_tracer,
        val dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted_tracer: dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted_tracer,
        val dev_bevents__realtime__enrichment__prof__transactions_with_clientid__dlq_tracer: dev_bevents__realtime__enrichment__prof__transactions_with_clientid__dlq_tracer,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { dev_bevents__realtime__case_71__uaspdto_tracer.loadTopic() }
//            launch { dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto_tracer.loadTopic() }
            launch { dev_bevents__realtime__enrichment__prof__transactions_with_clientid__dlq_tracer.loadTopic() }
        }
    }
}