package ru.vood.kafkaloaddata.senders.filter

import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CountProperties
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.senders.ToTopicLoader
import java.util.*

@Service
class dev_ivr__uasp_realtime__business_rules__uaspdto(
        override val messageProducer: MessageProducerInterface<String, String>,
        override val countProperties: CountProperties
) : ToTopicLoader<SomeDto> {

    override val topicName: String
        get() = "dev_bevents__realtime__aggregate_first_salary__uaspdto"

    override val logger: Logger = LoggerFactory.getLogger(dev_ivr__uasp_realtime__business_rules__uaspdto::class.java)

    override val generateFun: (Long) -> SomeDto = { id ->
        SomeDto(
                "global_id_$id",
                mutableMapOf(),
                mutableMapOf(),
                mutableMapOf(),
                mutableMapOf(),
                mutableMapOf(),
                mutableMapOf("system-classification" to "asd"),
                mutableMapOf("is_mortgage" to true),
                id.toString(),
                Calendar.getInstance().timeInMillis,

                )
    }
    override val timeOut: Optional<Int>
        get() = Optional.empty()


    override fun json(t: SomeDto): String = SerialisationConst.customJson.encodeToString(t)

}