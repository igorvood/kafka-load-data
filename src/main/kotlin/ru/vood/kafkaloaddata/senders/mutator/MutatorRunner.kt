package ru.vood.kafkaloaddata.senders.mutator

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner


@Service
class MutatorRunner(
        val dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto: dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto
) : CaseRunner {

    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)


    override fun runCase() {
        crScope.launch {
            dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto.loadTopic()
        }

    }
}