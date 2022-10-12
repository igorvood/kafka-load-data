package ru.vood.kafka.tools.kafkautil.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback
import java.util.*

@Service
class MessageProducer(
    private val kafkaTemplate: KafkaTemplate<String?, String>
) : MessageProducerInterface<String, String> {

    override fun sendMessage(topicName: String, key: String?, message: String) {
        val future: ListenableFuture<SendResult<String?, String>> =
            Optional.ofNullable(key).map { k -> kafkaTemplate.send(topicName, k, message) }
                .orElseGet { val send = kafkaTemplate.send(topicName, message)
                    send
                }
        future.addCallback(object : ListenableFutureCallback<SendResult<String?, String>> {
            override fun onSuccess(result: SendResult<String?, String>?) {
                println(
                    "Sent message=[$message] with offset=[" + result!!.recordMetadata
                        .offset() + "]"
                )
            }

            override fun onFailure(ex: Throwable) {
                println("Unable to send message=[" + message + "] due to : " + ex.message)
            }
        })
    }


}