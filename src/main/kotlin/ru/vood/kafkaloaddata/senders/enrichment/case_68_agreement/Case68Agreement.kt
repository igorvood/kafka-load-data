package ru.vood.kafkaloaddata.senders.enrichment.case_68_agreement

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class Case68Agreement(
        val dev_bevents_cft_way4_profile_udds_before_case68_uaspdto: dev_bevents_cft_way4_profile_udds_before_case68_uaspdto,
        val dev__dko_uasp__card_agreement_converted: dev__dko_uasp__card_agreement_converted,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
//            launch { dev_bevents_cft_way4_profile_udds_before_case68_uaspdto.loadTopic() }
            launch { dev__dko_uasp__card_agreement_converted.loadTopic() }

        }
    }
}