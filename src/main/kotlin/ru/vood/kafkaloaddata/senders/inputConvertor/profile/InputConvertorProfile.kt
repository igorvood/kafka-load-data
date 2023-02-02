package ru.vood.kafkaloaddata.senders.inputConvertor.profile

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class InputConvertorProfile(
    val profile_tx_out: profile_tx_out,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { profile_tx_out.loadTopic() }
        }
    }
}