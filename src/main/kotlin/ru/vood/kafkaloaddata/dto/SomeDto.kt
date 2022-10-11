package ru.vood.kafkaloaddata.dto

import kotlinx.serialization.Serializable
import java.math.BigDecimal


@Serializable
data class SomeDto(
    val id: String,
    val dataInt: Map<String, Int>,
    val dataLong: Map<String, Long>,
    val dataFloat: Map<String, Float>,
    val dataDouble: Map<String, Double>,
//    @Serializable(with = DecimalAsStringSerializer::class)
//    val dataDecimal: Map<String, BigDecimal> = mutableMapOf(),
//    val dataDecimal1: List< BigDecimal> = mutableListOf(),
    val dataString: Map<String, String>,
    val dataBoolean: Map<String, Boolean>,
    val uuid: String,
    val process_timestamp: Long,
    @Serializable(with = DecimalAsStringSerializer::class)
    val sadad : BigDecimal
)
//Serializer has not been found for type 'BigDecimal'. To use context serializer as fallback, explicitly annotate type or property with @Contextual