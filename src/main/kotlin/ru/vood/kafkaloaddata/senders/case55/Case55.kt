package ru.vood.kafkaloaddata.senders.case55

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class Case55(
    val dev__pp_fl_uasp__opyp: dev__pp_fl_uasp__opyp,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { dev__pp_fl_uasp__opyp.loadTopic() }
        }
    }
}