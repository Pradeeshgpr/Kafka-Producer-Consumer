package com.testKafka.consumer.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.testKafka.consumer.config.ConsumerConfig.COMSUMER_BEAN_NAME;

@Service
public class ConsumerService {

    private static final String TEST_TOPIC = "test";

    @Autowired
    @Qualifier(COMSUMER_BEAN_NAME)
    private Consumer<Long, String> consumer;

    public void testConsumer() throws Exception {
        while(true) {
            ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
            consumerRecords.forEach(record -> {
                System.out.println("Record Key " + record.key());
                System.out.println("Record value " + record.value());
                System.out.println("Record partition " + record.partition());
                System.out.println("Record offset " + record.offset());
            });
            // commits the offset of record to broker.
            consumer.commitAsync();
        }
    }

}
