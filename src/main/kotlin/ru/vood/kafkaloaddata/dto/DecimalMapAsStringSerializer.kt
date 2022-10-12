package ru.vood.kafkaloaddata.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.math.BigDecimal

object DecimalMapAsStringSerializer : KSerializer<Map<String, BigDecimal>> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("decimalStringMap", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Map<String, BigDecimal> {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: Map<String, BigDecimal>) {
        TODO("Not yet implemented")
    }

    //    override fun serialize(encoder: Encoder, value: BigDecimal) {
//        encoder.encodeString(value.toPlainString())
//    }
//
//    override fun deserialize(decoder: Decoder): BigDecimal {
//        val string = decoder.decodeString()
//        return BigDecimal(string)
//    }
}