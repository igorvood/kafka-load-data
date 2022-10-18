package ru.vood.kafkaloaddata.senders.filter

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner


@Service
class FilterRunner(
    val dev_ivr__uasp_realtime__business_rules__uaspdto :dev_ivr__uasp_realtime__business_rules__uaspdto
): CaseRunner {

    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)


    override fun runCase() {
        crScope.launch {
            dev_ivr__uasp_realtime__business_rules__uaspdto.loadTopic()
        }

    }
}