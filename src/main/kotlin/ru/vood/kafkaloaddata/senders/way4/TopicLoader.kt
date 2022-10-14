package ru.vood.kafkaloaddata.senders.way4

import org.slf4j.Logger
import ru.vood.kafkaloaddata.dto.Identity
import ru.vood.kafkaloaddata.producer.MessageProducerInterface
import java.util.*
import kotlin.math.abs

interface TopicLoader<T : Identity> {
    val logger: Logger

    val messageProducer: MessageProducerInterface<String, String>
    val generateFun: (Long) -> T

    val userCnt:Int

    val totalSendRecCnt: Int

    fun json(t: T): String

    fun beginTime() = Date().time

    suspend fun loadTopic(): Unit {
        logger.info("run $messageProducer")
        val batchSize: Int = 100000

        val beginTime = beginTime()
        var cnt: Long = 0
        val topicName = this.javaClass.simpleName

        while ((totalSendRecCnt==-1) || totalSendRecCnt>=cnt) {

            cnt += 1
            val abs = abs(UUID.randomUUID().toString().hashCode() % userCnt).toLong()

            val newDto = generateFun(abs)


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
//                if (totalSendRecCnt==-1) {
//                    Thread.sleep(30000)
//                }
            }


        }
        val endTime = Date().time
        val toDouble = (endTime - beginTime).toDouble()

        logger.info("Finish!!! Total seconds ${toDouble / 1000} $topicName")
    }


}
