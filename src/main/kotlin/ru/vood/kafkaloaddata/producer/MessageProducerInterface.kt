package ru.vood.kafkaloaddata.producer

interface MessageProducerInterface<K, V> {

    fun sendMessage(topicName: String, key: K?, message: V)

}
