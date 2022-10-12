package ru.vood.kafkaloaddata.senders.way4

import kotlinx.serialization.encodeToString
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kafka.tools.kafkautil.producer.MessageProducer
import ru.vood.kafka.tools.kafkautil.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.dto.SomeDto
import java.math.BigDecimal

@Service
class dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto(
    val messageProducer: MessageProducer
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        val someDto = SomeDto("str", mutableMapOf("asdas" to 1), mutableMapOf(),mutableMapOf(),mutableMapOf(),mutableMapOf(),mutableMapOf(),mutableMapOf(),"Sad",0, BigDecimal(12))

        messageProducer.sendMessage(this.javaClass.name,someDto.id, SerialisationConst.customJson.encodeToString(someDto) )

       /* while (true) {

        }*/
    }
}