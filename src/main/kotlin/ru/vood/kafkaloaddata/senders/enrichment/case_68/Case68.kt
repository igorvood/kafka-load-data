package ru.vood.kafkaloaddata.senders.enrichment.case_68

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class Case68(
        val dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto: dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto.loadTopic() }
        }
    }
}