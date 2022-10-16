package ru.vood.kafkaloaddata.senders.way4

import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CountProperties
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.senders.TopicLoader
import java.util.*

@Service
class dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto(
    override val messageProducer: MessageProducerInterface<String, String>,
    override val countProperties: CountProperties
) : TopicLoader<SomeDto> {

    override val logger: Logger = LoggerFactory.getLogger(dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto::class.java)

    override val generateFun: (Long) -> SomeDto = { id ->
        SomeDto(
            id.toString(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf("global_id" to "global_id_$id"),
            mutableMapOf(),
            id.toString(),
            Calendar.getInstance().timeInMillis,
        )
    }

    override fun json(t: SomeDto): String = SerialisationConst.customJson.encodeToString(t)

}