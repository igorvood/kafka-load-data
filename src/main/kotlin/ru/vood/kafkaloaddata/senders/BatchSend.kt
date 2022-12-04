package ru.vood.kafkaloaddata.senders

import arrow.core.Option
import arrow.core.orElse
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CaseListRunProperties

@Service
class BatchSend(
    val caseRunners: Map<String, CaseRunner>,
    val caseListRunProperties: CaseListRunProperties
) : CommandLineRunner {


    private fun validate() {
        val notFoundKeys = caseListRunProperties.caseList.map { it.name }
            .filter { !caseRunners.containsKey(it) }

        if (notFoundKeys.isNotEmpty()) {
            throw IllegalStateException(
                "${notFoundKeys.size} Cases  $notFoundKeys not found in\n${
                    caseRunners.keys.joinToString(
                        "\n"
                    )
                }"
            )
        }


    }

    override fun run(vararg args: String?) {
        validate()
        caseListRunProperties.caseList
            .forEach { caseName ->
                Option.fromNullable(caseRunners.get(caseName.name))
                    .map { srv -> srv.runCase() }
                    .orElse {
                        throw IllegalStateException("Case $caseName not found in\n${caseRunners.keys.joinToString("\n")}")
                    }

            }
    }
}