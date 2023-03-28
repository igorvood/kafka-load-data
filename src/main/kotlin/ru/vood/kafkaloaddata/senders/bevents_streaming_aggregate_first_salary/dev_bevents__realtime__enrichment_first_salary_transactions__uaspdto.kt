package ru.vood.kafkaloaddata.senders.bevents_streaming_aggregate_first_salary

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CountProperties
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.senders.ToTopicLoader
import ru.vood.kafkaloaddata.senders.enrichment.way4Flat.dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdtoFlat
import java.util.*

@Service
class dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto(
    override val messageProducer: MessageProducerInterface<String, String>,
    override val countProperties: CountProperties
) : ToTopicLoader<SomeDto> {

    override val topicName: String
        get() = "dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto"

    override val logger: Logger = LoggerFactory.getLogger(
        dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdtoFlat::class.java
    )

    override val timeOut: Optional<Int>
        get() = Optional.empty()

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

    override fun json(t: SomeDto): String =
//        SerialisationConst.customJson.encodeToString(t)
        """{"period":30,"product_rate":5.5,"mdm_id":"66756201","product_nm":"Vklad","account_num":"11111111111111111111"}"""

}