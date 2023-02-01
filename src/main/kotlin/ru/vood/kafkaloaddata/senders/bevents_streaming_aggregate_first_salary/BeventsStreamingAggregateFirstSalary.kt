package ru.vood.kafkaloaddata.senders.bevents_streaming_aggregate_first_salary

import kotlinx.coroutines.*
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.senders.CaseRunner

@Service
class BeventsStreamingAggregateFirstSalary(
    val dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto: dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto,
) : CaseRunner {


    private val job: CompletableJob = SupervisorJob()
    private val crScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)

    override fun runCase() {
        crScope.launch {
            launch { dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto.loadTopic() }
        }
    }
}