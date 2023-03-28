package ru.vood.kafkaloaddata.json

import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import org.junit.jupiter.api.Test
import ru.vood.kafkaloaddata.dto.SerialisationConst.customJson
import ru.vood.kafkaloaddata.dto.SomeDto
import java.math.BigDecimal

class SomeDtoSerializeTest {

    @Test
    fun serialisationTest(){
        val someDto = SomeDto("str", mutableMapOf("asdas" to 1), mutableMapOf(),mutableMapOf(),mutableMapOf(),mutableMapOf(),mutableMapOf(),mutableMapOf(),"Sad",0/*, BigDecimal(12)*/)
        val str = customJson.encodeToString(someDto)

        println(str)

        println(customJson.decodeFromString<SomeDto>(str))

        val encodeToString = customJson.encodeToString(QWER(1, 2.0))
        println(encodeToString)

        val parseToJsonElement = customJson.parseToJsonElement(encodeToString)

        println(parseToJsonElement)

    }
}

@kotlinx.serialization.Serializable
data class QWER(val int: Int,
                val Double: Double,
)