package ru.vood.kafkaloaddata.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import kotlin.io.path.toPath


@Configuration
@EnableConfigurationProperties(KafkaProperties::class)
class KafkaProducerConfig {

    @Bean
    fun producerFactory(kafkaProperties: KafkaProperties): ProducerFactory<String?, String> {
        val mutableMap: MutableMap<String, Any> = kafkaProperties.producer.properties.toMutableMap()

        mutableMap[ProducerConfig.ACKS_CONFIG] = kafkaProperties.producer.acks

        mutableMap[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers.joinToString(",")
        mutableMap[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        mutableMap[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name

        mutableMap["security.protocol"] = kafkaProperties.security.protocol

        mutableMap["ssl.truststore.location"] = kafkaProperties.ssl.trustStoreLocation.uri.toPath().toString()
        mutableMap["ssl.keystore.location"] = kafkaProperties.ssl.keyStoreLocation.uri.toPath().toString()

        mutableMap["ssl.truststore.password"] = kafkaProperties.ssl.trustStorePassword
        mutableMap["ssl.keystore.password"] = kafkaProperties.ssl.keyStorePassword
        mutableMap["ssl.key.password"] = kafkaProperties.ssl.keyPassword

        mutableMap["ssl.keystore.type"] = kafkaProperties.ssl.keyStoreType
        mutableMap["ssl.truststore.type"] = kafkaProperties.ssl.trustStoreType

        mutableMap["retries"] = kafkaProperties.producer.retries

        return DefaultKafkaProducerFactory(mutableMap)
    }

    @Bean
    fun kafkaTemplate(pf: ProducerFactory<String?, String>): KafkaTemplate<String?, String> {
        return KafkaTemplate(pf)
    }

}