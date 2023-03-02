package ru.vood.kafkaloaddata.senders.inputConvertor.customerProfileFull

import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.config.prop.CountProperties
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import ru.vood.kafkaloaddata.senders.ToTopicLoader
import ru.vood.kafkaloaddata.senders.enrichment.way4Flat.dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdtoFlat
import java.util.*

@Service
class dev_bevents__batch__ca_regulatory_client_id_of_profile__json(
    override val messageProducer: MessageProducerInterface<String, String>,
    override val countProperties: CountProperties
) : ToTopicLoader<SomeDto> {

    override val topicName: String
        get() = "dev_bevents__batch__ca_regulatory_client_id_of_profile__json"

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

    override fun json(t: SomeDto): String = "SerialisationConst.customJson.encodeToString(t)"
    val full = """{
  "contract_id": "897",
  "customer_id": "3812",
  "contract_num": "194"
}"""
    companion object{
        val json =""""""
    }
}