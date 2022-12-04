package ru.vood.kafkaloaddata.senders.enrichment.way4Flat

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CountProperties
import ru.vood.kafkaloaddata.dto.Identity
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.senders.ToTopicLoader

@Service
class dev_ivr__uasp_realtime__input_converter__mortgage__uaspdtoFlat(
    override val messageProducer: MessageProducerInterface<String, String>,
    override val countProperties: CountProperties
) : ToTopicLoader<MortageDto> {

    override val topicName: String
        get() = "dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto"

    override val logger: Logger =
        LoggerFactory.getLogger(dev_ivr__uasp_realtime__input_converter__mortgage__uaspdtoFlat::class.java)

    override val generateFun: (Long) -> MortageDto = { id ->
        MortageDto(
            id.toString(),
            true,
        )
    }

    override fun json(t: MortageDto): String = SerialisationConst.customJson.encodeToString(t)

}

@Serializable
data class MortageDto(
    val id1: String,
    val is_mortgage: Boolean
) : Identity {
    override fun id(): String = id1
}