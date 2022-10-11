package ru.vood.kafkaloaddata.json

import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import ru.vood.kafkaloaddata.dto.SomeDto
import java.math.BigDecimal

class SomeDtoSerializeTest {

    @Test
    fun asdasd(){
        val someDto = SomeDto("str", mutableMapOf("asdas" to 1), mutableMapOf(),mutableMapOf(),mutableMapOf(),mutableMapOf(),mutableMapOf(),"Sad",0, BigDecimal(12))
        val str = Json.encodeToString(someDto)

        println(str)

        println(Json.decodeFromString<SomeDto>(str))

    }
}