package ru.vood.kafkaloaddata.senders.tracer

import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CountProperties
import ru.vood.kafkaloaddata.dto.Identity
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.senders.ToTopicLoader
import ru.vood.kafkaloaddata.senders.enrichment.way4.dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto
import java.util.*
import kotlinx.serialization.Serializable

@Service
class dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted_tracer (
    override val messageProducer: MessageProducerInterface<String, String>,
    override val countProperties: CountProperties
) : ToTopicLoader<InetUUID> {

    override val topicName: String
        get() = "dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted"
    override val logger: Logger = LoggerFactory.getLogger(
        dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto::class.java
    )

    override val generateFun: (Long) -> InetUUID = { id ->
        InetUUID(
            id.toString(),
        )
    }
    override val timeOut: Optional<Int>
        get() = Optional.of(5000)


    override fun json(t: InetUUID): String = SerialisationConst.customJson.encodeToString(t)

}

@Serializable
data class InetUUID(val id1: String): Identity{
    override fun id(): String =id1
}