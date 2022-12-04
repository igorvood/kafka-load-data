package ru.vood.kafkaloaddata.senders.case55

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
import java.util.*

@Service
class dev__pp_fl_uasp__opyp(
    override val messageProducer: MessageProducerInterface<String, String>,
    override val countProperties: CountProperties
) : ToTopicLoader<PackageServiceInDto> {

    override val topicName: String
        get() = "dev__pp_fl_uasp__opyp"

    override val logger: Logger = LoggerFactory.getLogger(
        dev__pp_fl_uasp__opyp::class.java
    )

    override val timeOut: Optional<Int>
        get() = Optional.empty()
    override val generateFun: (Long) -> PackageServiceInDto = { id ->
        PackageServiceInDto(
            "OPERATION_ID" + id.toString(),
            "MDM_ID" + id.toString(),
            "EVENT_DTTM" + id.toString(),
            "NEW_PACKAGE" + id.toString(),
            "OLD_PACKAGE" + id.toString(),

            )
    }

    override fun json(t: PackageServiceInDto): String = SerialisationConst.customJson.encodeToString(t)


}

@Serializable
data class PackageServiceInDto(
    val OPERATION_ID: String,
    val MDM_ID: String,
    val EVENT_DTTM: String,
    val NEW_PACKAGE: String,
    val OLD_PACKAGE: String,
) : Identity {
    override fun id(): String? = OPERATION_ID
}