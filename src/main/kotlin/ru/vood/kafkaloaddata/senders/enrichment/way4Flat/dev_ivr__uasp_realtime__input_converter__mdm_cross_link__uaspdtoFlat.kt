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
class dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdtoFlat(
    override val messageProducer: MessageProducerInterface<String, String>,
    override val countProperties: CountProperties
) : ToTopicLoader<MdmIdDto> {

    override val topicName: String
        get() = "dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto"

    override val logger: Logger = LoggerFactory.getLogger(
        dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdtoFlat::class.java
    )

    override val generateFun: (Long) -> MdmIdDto = { id ->
        MdmIdDto(
            id.toString(),
            "global_id_$id"
        )
    }

    override fun json(t: MdmIdDto): String = SerialisationConst.customJson.encodeToString(t)

}

@Serializable
data class MdmIdDto(
    val id: String,
    val global_id1: String,
) : Identity {
    override fun id(): String = id
}