package ru.vood.kafkaloaddata.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import ru.vood.kafkaloaddata.dto.asd.sadas
import java.math.BigDecimal


@Serializable

data class SomeDto(
    val id: String,
    val dataInt: Map<String, Int>,
    val dataLong: Map<String, Long>,
    val dataFloat: Map<String, Float>,
    val dataDouble: Map<String, Double>,
//    @Serializable(with = DecimalAsStringSerializer::class)
    @Contextual
    val dataDecimal: Map<String, BigDecimal>,
//    val dataDecimal1: List< BigDecimal> = mutableListOf(),
    val dataString: Map<String, String>,
    val dataBoolean: Map<String, Boolean>,
    val uuid: String,
    val process_timestamp: Long,
//    @Serializable(with = DecimalAsStringSerializer::class)
    @Contextual
    val sadad: BigDecimal


)

