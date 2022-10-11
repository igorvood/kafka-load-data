package ru.vood.kafkaloaddata.json

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class SomeDtoSerializeTest {

    @Test
    fun asdasd(){
        val someDto = ru.vood.kafkaloaddata.dto.SomeDto("str")
        Json.encodeToString()
    }
}