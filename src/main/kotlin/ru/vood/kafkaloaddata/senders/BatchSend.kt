package ru.vood.kafkaloaddata.senders

import arrow.core.Option
import arrow.core.orElse
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CaseListRunProperties

@Service
class BatchSend(
    val cases: Map<String, CaseRunner>,
    val caseListRunProperties: CaseListRunProperties
    ) : CommandLineRunner {

    override fun run(vararg args: String?) {
        caseListRunProperties.caseList
            .forEach {caseName ->
                Option.fromNullable(cases.get(caseName.name))
                    .map { srv -> srv.runCase() }
                    .orElse { throw  IllegalStateException("Case $caseName not found in\n${cases.keys.joinToString("\n")}")
                    }

            }
    }
}