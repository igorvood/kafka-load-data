package ru.vood.kafkaloaddata.senders.inputConvertor.inputConvertorProfile

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class InputConvertorCustomerProfile(
    val dev__wpr_profile_uasp__tran: dev__wpr_profile_uasp__tran,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { dev__wpr_profile_uasp__tran.loadTopic() }
        }
    }
}