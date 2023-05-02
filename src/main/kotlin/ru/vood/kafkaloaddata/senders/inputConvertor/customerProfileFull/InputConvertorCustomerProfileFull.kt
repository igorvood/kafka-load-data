package ru.vood.kafkaloaddata.senders.inputConvertor.customerProfileFull

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class InputConvertorCustomerProfileFull(
        val dev_bevents__batch__ca_regulatory_client_id_of_profile__json: dev_bevents__batch__ca_regulatory_client_id_of_profile__json,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { dev_bevents__batch__ca_regulatory_client_id_of_profile__json.loadTopic() }
        }
    }
}