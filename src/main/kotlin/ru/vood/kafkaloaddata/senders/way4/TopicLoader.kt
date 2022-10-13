package ru.vood.kafkaloaddata.senders.way4

import org.slf4j.Logger
import ru.vood.kafkaloaddata.dto.IdentityMy
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import java.util.*

interface TopicLoader<T : IdentityMy> {
    val logger: Logger

    val batchSize: Int
    val messageProducer: MessageProducerInterface<String, String>
    val generateFun: (Long) -> T

    fun json(t: T): String

    fun beginTime() = Date().time

    suspend fun loadTopic(): Unit {
        logger.info("run ${messageProducer.toString()}")

        val beginTime = beginTime()
        var cnt: Long = 0
        val topicName = this.javaClass.simpleName

        while (true) {

            cnt += 1

            val newDto = generateFun(cnt)


            messageProducer.sendMessage(
                topicName,
                newDto.id(),
                json(newDto)
            )

            if (cnt.toInt() % batchSize == 0) {
                val endTime = Date().time
                val d = batchSize.toDouble() * (endTime - beginTime).toDouble() / cnt.toDouble()
                logger.info("send $cnt reccord. $d milliseconds per  $batchSize. TopicName $topicName")
            }


        }
    }


}
