package ru.vood.kafkaloaddata.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.CharArraySerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.serializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import java.math.BigDecimal


object asd {

    val sadas = MapSerializer(String.serializer(), DecimalAsStringSerializer)

    val format =   Json {
        serializersModule = SerializersModule {
            this.contextual(String.serializer())
            contextual(Int.serializer())
            contextual(Float.serializer())
            contextual(Double.serializer())
            contextual(Boolean.serializer())
            contextual(Char.serializer())
            contextual(Byte.serializer())
            contextual(DecimalAsStringSerializer)
            contextual(DecimalMapAsStringSerializer)
        }
    }
}