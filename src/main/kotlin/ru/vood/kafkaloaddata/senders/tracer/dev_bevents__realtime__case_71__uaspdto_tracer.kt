package ru.vood.kafkaloaddata.senders.tracer

import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CountProperties
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.senders.ToTopicLoader
import ru.vood.kafkaloaddata.senders.enrichment.way4.dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto
import java.util.*

@Service
class dev_bevents__realtime__case_71__uaspdto_tracer(
        override val messageProducer: MessageProducerInterface<String, String>,
        override val countProperties: CountProperties
) : ToTopicLoader<SomeDto> {

    override val topicName: String
        get() = "dev_bevents__realtime__case_71__uaspdto"

    override val logger: Logger = LoggerFactory.getLogger(
            dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto::class.java
    )

    override val generateFun: (Long) -> SomeDto = { id ->
        SomeDto(
                id.toString(),
                mutableMapOf(),
                mutableMapOf(),
                mutableMapOf(),
                mutableMapOf(),
                mutableMapOf(),
                mutableMapOf(),
                mutableMapOf(),
                id.toString(),
                Calendar.getInstance().timeInMillis,
        )
    }
    override val timeOut: Optional<Int>
        get() = Optional.of(5000)

    override fun json(t: SomeDto): String = SerialisationConst.customJson.encodeToString(t)

}