package ru.vood.kafkaloaddata.senders.way4

import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import java.math.BigDecimal

@Service
class dev_ivr__uasp_realtime__input_converter__mortgage__dlq(
    override val messageProducer: MessageProducerInterface<String, String>
) : TopicLoader<SomeDto> {

    override val logger: Logger = LoggerFactory.getLogger(dev_ivr__uasp_realtime__input_converter__mortgage__dlq::class.java)

    override val batchSize = 100000

    override val generateFun: (Long) -> SomeDto = { id ->
        SomeDto(
            id.toString(),
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
    }

    override fun json(t: SomeDto): String = SerialisationConst.customJson.encodeToString(t)

}