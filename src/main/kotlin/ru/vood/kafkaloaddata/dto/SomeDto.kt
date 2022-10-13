package ru.vood.kafkaloaddata.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.math.BigDecimal


@Serializable

data class SomeDto(
    val id: String,
    val dataInt: Map<String, Int>,
    val dataLong: Map<String, Long>,
    val dataFloat: Map<String, Float>,
    val dataDouble: Map<String, Double>,

//    @Serializable(with = DecimalMapAsStringSerializer::class)
//    @Contextual
//    val dataDecimal: Map<String, BigDecimal>,
    val dataDecimal: Map<String, Double>,

    val dataString: Map<String, String>,
    val dataBoolean: Map<String, Boolean>,
    val uuid: String,
    val process_timestamp: Long,
//    @Serializable(with = DecimalAsStringSerializer::class)
    @Contextual
    val sadad: BigDecimal
): IdentityMy {
    override fun id(): String = id
}

