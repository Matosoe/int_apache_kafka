package br.com.fiap.util;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import br.com.fiap.model.BolsaFamilia;

/**
 * ConsumerCreator
 */
public class ConsumerCreator {

    public static Consumer<String, BolsaFamilia> createConsumer(String brokers, String groupId, String topicName) {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", brokers);

        properties.setProperty("group.id", groupId);

        properties.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        properties.setProperty("auto.offset.reset","earliest");

        final KafkaConsumer<String, BolsaFamilia> consumer = new KafkaConsumer<>(properties, new StringDeserializer(), new KafkaJsonDeserializer());

        consumer.subscribe(Arrays.asList(topicName));
        
		return consumer;
    }
}