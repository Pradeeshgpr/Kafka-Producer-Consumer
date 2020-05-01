package com.testKafka.producer.service;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.testKafka.producer.config.ProducerConfig.PRODUCER_BEAN_NAME;
import static com.testKafka.producer.constants.ProducerConstants.TEST_TOPIC_NAME;
import static com.testKafka.producer.constants.ProducerConstants.TEST_MESSAGE;

@Service
public class ProducerService {

    @Autowired
    @Qualifier(PRODUCER_BEAN_NAME)
    private Producer<Long, String> producer;

    public void sendTestMessage() throws Exception{
        producer.beginTransaction();
        producer.send(new ProducerRecord<Long, String>(TEST_TOPIC_NAME, TEST_MESSAGE));
        producer.commitTransaction();
    }

}
