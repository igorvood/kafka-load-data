package ru.vood.kafkaloaddata.senders.way4

import kotlinx.serialization.encodeToString
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kafkaloaddata.dto.SerialisationConst
import ru.vood.kafkaloaddata.dto.SomeDto
import ru.vood.kafkaloaddata.producer.MessageProducer
import java.math.BigDecimal
import java.util.*

@Service
class dev_ivr__uasp_realtime__input_converter__mortgage__dlq(
    val messageProducer: MessageProducer
) : CommandLineRunner {


    private val logger = LoggerFactory.getLogger(dev_ivr__uasp_realtime__input_converter__mortgage__dlq::class.java)
    private var cnt: Long = 0

    private val batchSize = 100000

    private val beginTime = Date().time


    val generateFun: (Long) -> SomeDto = { id ->
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

    override fun run(vararg args: String?) {

        while (true) {

            cnt += 1

            val newDto = generateFun(cnt)

            messageProducer.sendMessage(
                this.javaClass.simpleName,
                newDto.id,
                SerialisationConst.customJson.encodeToString(newDto)
            )

            if (cnt.toInt() % batchSize == 0) {
                val endTime = Date().time
                val d = batchSize.toDouble() * (endTime - beginTime).toDouble() / cnt.toDouble()
                logger.info("send $cnt reccord. $d milliseconds per  $batchSize")
            }


        }
    }
}