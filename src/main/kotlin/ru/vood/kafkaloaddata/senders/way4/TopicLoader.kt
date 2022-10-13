package ru.vood.kafkaloaddata.senders.way4

import org.slf4j.Logger
import ru.vood.kafkaloaddata.dto.Identity
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import java.util.*

interface TopicLoader<T : Identity> {
    val logger: Logger

    val batchSize: Int
    val messageProducer: MessageProducerInterface<String, String>
    val generateFun: (Long) -> T

    fun json(t: T): String

    fun beginTime() = Date().time

    suspend fun loadTopic(): Unit {
        logger.info("run $messageProducer")

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
                val toDouble = (endTime - beginTime).toDouble()
                val d = 1000 *  cnt.toDouble()/ toDouble
                logger.info("send $cnt record. $d records per second. TopicName $topicName, seconds ${toDouble/1000}")
            }


        }
    }


}