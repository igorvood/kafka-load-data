package ru.vood.kafkaloaddata.config.prop

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "case")
data class CaseListRunProperties(
        val caseList: List<Case>
) {
    data class Case(val name: String)
}
