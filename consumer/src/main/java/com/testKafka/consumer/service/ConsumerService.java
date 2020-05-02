package com.testKafka.consumer.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.record.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.TimerTask;

import static com.testKafka.consumer.config.ConsumerConfig.COMSUMER_BEAN_NAME;

@Service
public class ConsumerService {

    private static final String TEST_TOPIC = "test";

    @Autowired
    @Qualifier(COMSUMER_BEAN_NAME)
    private Consumer<Long, String> consumer;

    public void testConsumer() throws Exception {
        long startTime = new Date().getTime();
        while(true) {
            ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
            boolean isTestTopic = false;
            Iterator recordIter = consumerRecords.iterator();
            while (recordIter.hasNext()) {
                ConsumerRecord<Long, String> record = (ConsumerRecord<Long, String>) recordIter.next();
                System.out.println("Record Key " + record.key());
                System.out.println("Record value " + record.value());
                System.out.println("Record partition " + record.partition());
                System.out.println("Record offset " + record.offset());
                if (TEST_TOPIC.equals(record.topic())) {
                    isTestTopic = true;
                }
            }
            if ((startTime - new Date().getTime()) > 2000) {
                throw new Exception();
            }
            if (isTestTopic) {
                break;
            }
        }
    }

}
