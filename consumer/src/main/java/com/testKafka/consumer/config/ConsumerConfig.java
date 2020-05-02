package com.testKafka.consumer.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.MAX_POLL_RECORDS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG;

@Configuration
public class ConsumerConfig {

    public static final String COMSUMER_BEAN_NAME = "ConsumerConfig" ;

    @Value("${com.testKafka.producer.CLIENT_ID}")
    private String CLIENT_ID;

    @Value("${com.testKafka.producer.BROKER}")
    private String KAFKA_BROKERS;

    @Value("${com.testKafka.producer.GROUP_ID_CONFIG_CONST}")
    private String GROUP_ID_CONFIG_CONST;

    @Value("#{${com.testKafka.producer.TOPICS}}")
    private List<String> TOPICS;

    @Value("${com.testKafka.producer.MAX_POLL_RECORDS}")
    private String MAX_POLL_RECORDS;

    @Value("${com.testKafka.producer.OFFSET_RESET_EARLIER}")
    private String OFFSET_RESET_EARLIER;

    @Bean(COMSUMER_BEAN_NAME)
    public Consumer<Long, String> createConsumer() {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKERS);
        props.put(GROUP_ID_CONFIG, GROUP_ID_CONFIG_CONST);
        props.put(KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(MAX_POLL_RECORDS_CONFIG, MAX_POLL_RECORDS);
        props.put(ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(AUTO_OFFSET_RESET_CONFIG, OFFSET_RESET_EARLIER);
        Consumer<Long, String> consumer = new KafkaConsumer<Long, String>(props);
        consumer.subscribe(TOPICS);
        return consumer;
    }
}
