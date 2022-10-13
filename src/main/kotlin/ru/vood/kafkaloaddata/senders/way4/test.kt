package ru.vood.kafkaloaddata.senders.way4

import kotlinx.serialization.encodeToString
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.producer.MessageProducer
import java.math.BigDecimal

@Service
class test(
    val messageProducer: MessageProducer
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        val someDto = SomeDto(
            "str",
            mutableMapOf("asdas" to 1),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            "Sad",
            0,
            BigDecimal(12)
        )

        messageProducer.sendMessage(
            this.javaClass.simpleName,
            someDto.id,
            SerialisationConst.customJson.encodeToString(someDto)
        )

        /* while (true) {

         }*/
    }
}