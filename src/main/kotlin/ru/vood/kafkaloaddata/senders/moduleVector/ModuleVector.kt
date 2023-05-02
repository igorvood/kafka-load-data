package ru.vood.kafkaloaddata.senders.moduleVector

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class ModuleVector(
        val dev_bevents__realtime__case_71__uaspdto_tracer: dev_bevents__realtime__filter_first_salary__uaspdto,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { dev_bevents__realtime__case_71__uaspdto_tracer.loadTopic() }
        }
    }
}