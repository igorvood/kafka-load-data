package ru.vood.kafkaloaddata.dto

import kotlinx.serialization.Serializable
import java.math.BigDecimal


@Serializable
data class SomeDto(
    val id: String,
    val dataInt: Map<String, Int> = mutableMapOf(),
    val dataLong: Map<String, Long> = mutableMapOf(),
    val dataFloat: Map<String, Float> = mutableMapOf(),
    val dataDouble: Map<String, Double> = mutableMapOf(),
//    @Serializable(with = DecimalAsStringSerializer::class)
//    val dataDecimal: Map<String, BigDecimal> = mutableMapOf(),
//    val dataDecimal1: List< BigDecimal> = mutableListOf(),
    val dataString: Map<String, String> = mutableMapOf(),
    val dataBoolean: Map<String, Boolean> = mutableMapOf(),
    val uuid: String = "wsdasd",
    val process_timestamp: Long = 0
)
//Serializer has not been found for type 'BigDecimal'. To use context serializer as fallback, explicitly annotate type or property with @Contextual